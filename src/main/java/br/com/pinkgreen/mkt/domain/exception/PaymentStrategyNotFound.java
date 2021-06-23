package br.com.pinkgreen.mkt.domain.exception;

public class PaymentStrategyNotFound extends RuntimeException {
    public PaymentStrategyNotFound(String message) {
        super(message);
    }

    public PaymentStrategyNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
