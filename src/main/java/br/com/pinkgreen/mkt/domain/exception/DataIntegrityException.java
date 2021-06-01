package br.com.pinkgreen.mkt.domain.exception;

public class DataIntegrityException extends Exception {
    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }
}
