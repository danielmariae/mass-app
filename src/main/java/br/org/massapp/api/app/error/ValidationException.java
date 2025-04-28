package br.org.massapp.api.app.error;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}