package com.neoapps.model.product;

import com.neoapps.exceptions.DomainException;

public record Stock(Integer value) {

    public Stock {
        validate(value);
    }

    public void validate(Integer value) {
        if (value == null) throw new DomainException("Can't be null", "Stock");
        if (value < 0) {
            throw new DomainException("Stock can't be negative, " + value + " is an invalid quantity", "Stock");
        }
    }
}
