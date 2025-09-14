package com.neoapps.model.product;

import com.neoapps.exceptions.DomainException;

import java.math.BigDecimal;

public class WholeSalePrice {

    private final BigDecimal value;

    public WholeSalePrice(Double value) {
        validate(value);
        this.value = BigDecimal.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WholeSalePrice other)) return false;

        return this.equals(other);

    }

    public BigDecimal value() {
        return value;
    }

    public void validate(Double value) {
        if (value == null) throw new DomainException("Can't be null", "WholeSalePrice");
        if (value <= 0) throw new DomainException("Can't be equal or less than cero", "WholeSalePrice");
    }
}
