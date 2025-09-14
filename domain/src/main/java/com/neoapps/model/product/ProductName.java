package com.neoapps.model.product;

import com.neoapps.exceptions.DomainException;

public record ProductName(String value) {
    public ProductName {
        validate(value);
    }

    private void validate(String value) {
        if (value.isBlank()) throw new DomainException("The name of the product can't be empty", "ProductName");
        if (value.length() <= 2) {
            throw new DomainException("The name of the product can't have less than 3 characters", "ProductName");
        }
    }
}
