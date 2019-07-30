package com.example.Restaurant.exceptions;

public class InvalidValueException extends PerformaException {
    private static final long serialVersionUID = 1L;

    public InvalidValueException(String message, String... args) {
        super(message, args);
    }

    public InvalidValueException(String message, Throwable cause, String... args) {
        super(message, cause, args);
    }
}
