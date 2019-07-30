package com.example.Restaurant.exceptions;

public class CannotUpdateRouteException extends PerformaException {
    private static final long serialVersionUID = 1L;

    public CannotUpdateRouteException(String message, String... args) {

        super(message, args);
    }
}

