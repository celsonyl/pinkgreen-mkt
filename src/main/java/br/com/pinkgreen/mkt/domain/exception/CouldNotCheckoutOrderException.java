package br.com.pinkgreen.mkt.domain.exception;

public class CouldNotCheckoutOrderException extends Exception {
    public CouldNotCheckoutOrderException(String message) {
        super(message);
    }

    public CouldNotCheckoutOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
