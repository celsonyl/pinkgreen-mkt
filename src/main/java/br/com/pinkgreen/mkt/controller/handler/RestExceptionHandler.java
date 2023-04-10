package br.com.pinkgreen.mkt.controller.handler;

import br.com.pinkgreen.mkt.controller.handler.model.StandardError;
import br.com.pinkgreen.mkt.controller.handler.model.ValidationError;
import br.com.pinkgreen.mkt.domain.exception.CouldNotCheckoutOrderException;
import br.com.pinkgreen.mkt.domain.exception.DataIntegrityException;
import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.exception.BrandIsNotAbleToBeDeletedException;
import br.com.pinkgreen.mkt.exception.OrderNotFoundException;
import br.com.pinkgreen.mkt.exception.SkuNotContainedOnOrderException;
import br.com.pinkgreen.mkt.exception.SkuOrderEvaluationNotFoundException;
import br.com.pinkgreen.mkt.usecase.exception.InvalidStatusTransitionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.notFound;

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

    @ExceptionHandler(BrandIsNotAbleToBeDeletedException.class)
    public ResponseEntity<StandardError> brandNotAbleToBeDeletedException(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(StandardError.builder()
                .message("Você não pode deletar uma marca com produtos ativos/relacionados")
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(InvalidCustomerIdException.class)
    public ResponseEntity<StandardError> invalidCustomerId(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError.builder()
                .message("CustomerId inválido")
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(SkuNotContainedOnOrderException.class)
    public ResponseEntity<StandardError> invalidSkuCode(HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(StandardError.builder()
                .message("Sku code invalid!")
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Void> orderNotFound(OrderNotFoundException e) {
        return notFound().build();
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error, HttpServletRequest request) {
        var standardError = new StandardError(error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(SkuOrderEvaluationNotFoundException.class)
    public ResponseEntity<StandardError> orderEvaluationtNotFound(SkuOrderEvaluationNotFoundException error, HttpServletRequest request) {
        var standardError = new StandardError(error.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityException e, HttpServletRequest request) {
        var standardError = new StandardError(e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(standardError);
    }

    @ExceptionHandler(CouldNotCheckoutOrderException.class)
    public ResponseEntity<StandardError> couldNotCheckoutOrderException(CouldNotCheckoutOrderException e, HttpServletRequest request) {
        var standardError = new StandardError(e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> accessDenied(AccessDeniedException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(StandardError.builder()
                .message("Você não possui autorização para acessar isso!")
                .path(request.getRequestURI())
                .build());
    }

    @ExceptionHandler(InvalidStatusTransitionException.class)
    public ResponseEntity<StandardError> invalidOrderStatusTransition(InvalidStatusTransitionException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(StandardError.builder()
                .message("Transição de status inválida!")
                .path(request.getRequestURI())
                .build());
    }
}
