package com.neoapps.exceptions;

public class DomainException extends RuntimeException {

    private final String field;

    public DomainException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
