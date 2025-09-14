package com.neoapps.model.category;

import com.neoapps.exceptions.DomainException;

public record CategoryDescription(String value) {
    public CategoryDescription {
        validate(value);
    }

    private void validate(String value) {
        if (value.isBlank()) {
            throw new DomainException("The category description can't be empty", "CategoryDescription");
        }
        if (value.length() < 8) {
            throw new DomainException("The category description can't have less than 8 characters", "CategoryDescription");
        }
    }
}
