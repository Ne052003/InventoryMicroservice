package com.neoapps.model.category;

import com.neoapps.exceptions.DomainException;

public record CategoryName(String value) {
    public CategoryName {
        validate(value);
    }

    private void validate(String value) {
        if (value.isBlank()) throw new DomainException("The name of the category can't be empty", "CategoryName");
        if (value.length() <= 2) {
            throw new DomainException("The name of the category can't have less than 3 characters", "CategoryName");
        }
    }
}
