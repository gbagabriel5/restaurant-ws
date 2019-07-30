package com.example.Restaurant.exceptions;

public class CannotInsertHistoryOrUpdateHeaderException extends PerformaException {

    private static final long serialVersionUID = 1L;

    public CannotInsertHistoryOrUpdateHeaderException(String message, String... args) {

        super(message, args);
    }

}