package com.neoapps.model.product;

import com.neoapps.exceptions.DomainException;

import java.math.BigDecimal;

public class RetailPrice {

    private final BigDecimal value;

    public RetailPrice(Double value) {
        validate(value);
        this.value = BigDecimal.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RetailPrice other)) return false;

        return this.value.equals(other.value);

    }

    public BigDecimal value() {
        return value;
    }

    private void validate(Double value) {
        if (value == null) throw new DomainException("Can't be null", "RetailPrice");
        if (value <= 0) throw new DomainException("Can't be equal or less than cero", "RetailPrice");
    }
}
