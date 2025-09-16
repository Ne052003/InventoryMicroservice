package com.neoapps.driven_adapters.exceptions;

import lombok.Getter;

public class RepositoryException extends RuntimeException {
    @Getter
    private final String field;

    public RepositoryException(String message, String field) {
        super(message);
        this.field = field;
    }
}
