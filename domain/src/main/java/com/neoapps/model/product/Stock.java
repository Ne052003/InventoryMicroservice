package com.neoapps.model.product;

import com.neoapps.exceptions.DomainException;

public record Stock(Integer value) {

    public Stock {
        validate(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Stock other)) return false;

        return this.value.equals(other.value);
    }

    public void validate(Integer value) {
        if (value == null) throw new DomainException("Can't be null", "Stock");
        if (value < 0) {
            throw new DomainException("Stock can't be negative, " + value + " is an invalid quantity", "Stock");
        }
    }
}
