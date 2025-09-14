package com.neoapps.model.supplier;

import com.neoapps.exceptions.DomainException;

public record SupplierEmail(String value) {

    public SupplierEmail {
        validate(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SupplierEmail other)) return false;

        return this.equals(other);

    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new DomainException("Supplier Email can't be empty", "SupplierEmail");
        }
        if (!(value.matches("^(.+)@(\\S+)$"))) throw new DomainException("Incorrect email format", "SupplierEmail");
    }

}
