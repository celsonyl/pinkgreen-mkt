package br.com.pinkgreen.mkt.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodValidation(MethodArgumentNotValidException error, HttpServletRequest request) {
        ValidationError err = new ValidationError("Erro de validação", request.getRequestURI());

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
}
