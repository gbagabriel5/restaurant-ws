package com.example.Restaurant.exceptions;

public final class InvalidEntityException extends PerformaException {
    private static final long serialVersionUID = 1L;

    public InvalidEntityException(String message, String... args) {
        super(message, args);
    }

    public InvalidEntityException(String message, Throwable cause, String... args) {
        super(message, cause, args);
    }
}
