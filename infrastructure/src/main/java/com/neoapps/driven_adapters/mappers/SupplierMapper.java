package com.neoapps.driven_adapters.mappers;

import com.neoapps.driven_adapters.entities.SupplierEntity;
import com.neoapps.model.supplier.Supplier;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {

    public Supplier toSupplier(SupplierEntity supplierEntity) {
        if (supplierEntity == null) {
            return null;
        }
        Supplier supplier = new Supplier();
        supplier.setId(supplierEntity.getId());
        supplier.setName(supplierEntity.getName());
        supplier.setEmail(supplierEntity.getEmail());

        return supplier;
    }

    public SupplierEntity toSupplierEntity(Supplier supplier) {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setId(supplier.getId());

        return supplierEntity;
    }
}
