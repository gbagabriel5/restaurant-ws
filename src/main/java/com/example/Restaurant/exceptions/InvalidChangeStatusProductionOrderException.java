package com.example.Restaurant.exceptions;

public class InvalidChangeStatusProductionOrderException extends PerformaException {

    private static final long serialVersionUID = 1L;

    public InvalidChangeStatusProductionOrderException(String message, String... args) {
        super(message, args);
    }

    public InvalidChangeStatusProductionOrderException(String message, Throwable cause, String... args) {
        super(message, cause, args);
    }
}
