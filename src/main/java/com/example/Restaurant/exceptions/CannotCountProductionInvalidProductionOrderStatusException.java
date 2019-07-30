package com.example.Restaurant.exceptions;

public class CannotCountProductionInvalidProductionOrderStatusException extends PerformaException {

    private static final long serialVersionUID = 1L;

    public CannotCountProductionInvalidProductionOrderStatusException(String message, String... args) {
        super(message, args);
    }

}
