package com.example.Restaurant.exceptions;

public class CannotInsertTechnicalAnalysisOrUpdateHeaderException extends PerformaException {
    private static final long serialVersionUID = 1L;

    public CannotInsertTechnicalAnalysisOrUpdateHeaderException(String message, String... args) {

        super(message, args);
    }
}

