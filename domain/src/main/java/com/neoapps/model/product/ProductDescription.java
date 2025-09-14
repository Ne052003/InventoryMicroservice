package com.neoapps.model.product;

import com.neoapps.exceptions.DomainException;

public record ProductDescription(String value) {

    public ProductDescription {
        validate(value);
    }

    private void validate(String value) {
        if (value.isBlank()) throw new DomainException("The product description can't be empty", "ProductDescription");
        if (value.length() < 5) {
            throw new DomainException("The product description can't have less than 3 characters", "ProductDescription");
        }
    }
}
