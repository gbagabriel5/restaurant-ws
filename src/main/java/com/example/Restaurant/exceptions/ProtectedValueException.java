package com.example.Restaurant.exceptions;

public class ProtectedValueException extends PerformaException {

    private static final long serialVersionUID = 1L;
    private static final String APP_PROTECTED_VALUE = "app.protectedValue";

    public ProtectedValueException() {
        super(APP_PROTECTED_VALUE);
    }

    public ProtectedValueException(String... args) {
        super(APP_PROTECTED_VALUE, args);
    }

    public ProtectedValueException(String message, String... args) {
        super(message, args);
    }

    public ProtectedValueException(String message, Throwable cause, String... args) {
        super(message, cause, args);
    }
}
