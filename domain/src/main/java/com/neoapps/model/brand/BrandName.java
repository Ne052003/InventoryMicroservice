package com.neoapps.model.brand;

import com.neoapps.exceptions.DomainException;

public record BrandName(String value) {
    public BrandName {
        validate(value);
    }

    private void validate(String value) {
        if (value.isBlank()) throw new DomainException("The name of the brand can't be empty", "BrandName");
        if (value.length() <= 2) {
            throw new DomainException("The name of the brand can't have less than 3 characters", "BrandName");
        }
    }
}
