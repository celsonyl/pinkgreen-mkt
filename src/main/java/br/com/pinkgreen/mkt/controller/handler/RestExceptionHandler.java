package br.com.pinkgreen.mkt.controller.handler;

import br.com.pinkgreen.mkt.controller.handler.model.StandardError;
import br.com.pinkgreen.mkt.controller.handler.model.ValidationError;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodValidation(MethodArgumentNotValidException error, HttpServletRequest request) {
        var err = new ValidationError("Erro de validação", request.getRequestURI());

        for (FieldError x : error.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

    @ExceptionHandler(InvalidCustomerIdException.class)
    public ResponseEntity<StandardError> invalidCustomerId(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError.builder()
                .message("CustomerId inválido")
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error,HttpServletRequest request){
        var standardError = new StandardError(error.getMessage(),request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

}