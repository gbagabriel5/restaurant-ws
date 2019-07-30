package com.example.Restaurant.exceptions;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public final class NotEqualsException extends InvalidValueException {
    private static final long serialVersionUID = 1L;

    public NotEqualsException(String message, String... args) {
        super(message, args);
    }

}
