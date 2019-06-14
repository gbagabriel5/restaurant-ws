package com.example.Restaurant.exceptions;

public class DefaultException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DefaultException(String message) {
        super(message);
    }
}