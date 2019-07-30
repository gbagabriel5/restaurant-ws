package com.example.Restaurant.exceptions;

public class EmployeeLockedException extends PerformaException {

    private static final long serialVersionUID = 1L;

    public EmployeeLockedException(String message, String... args) {
        super(message, args);
    }

}