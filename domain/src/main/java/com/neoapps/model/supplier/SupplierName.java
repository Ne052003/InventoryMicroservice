package com.neoapps.model.supplier;

public record SupplierName(String value) {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SupplierName other)) return false;

        return this.equals(other);

    }
}
