package br.com.pinkgreen.mkt.controller.exception;

public class InvalidCustomerIdException extends Throwable {
    public InvalidCustomerIdException(String message) {
        super(message);
    }

    public InvalidCustomerIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
