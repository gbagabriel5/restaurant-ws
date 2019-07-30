package com.example.Restaurant.exceptions;

public class EmployeeIsAlreadyUnlocked extends PerformaException {

    private static final long serialVersionUID = 1L;

    public EmployeeIsAlreadyUnlocked(String message, String... args) {
        super(message, args);
    }

}
