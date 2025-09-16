package com.neoapps.driven_adapters.mappers;

import com.neoapps.driven_adapters.entities.StockUpdateEntity;
import com.neoapps.model.stockUpdate.StockUpdate;
import org.springframework.stereotype.Component;

@Component
public class StockUpdateMapper {

    public StockUpdateEntity toEntity(StockUpdate stockUpdate) {

        if (stockUpdate == null) {
            return null;
        }
        return new StockUpdateEntity(
                stockUpdate.getEmployeeId(),
                stockUpdate.getProductId(),
                stockUpdate.getTransactionType(),
                stockUpdate.getTransactionDate(),
                stockUpdate.getQuantity());

    }

    public StockUpdate toStockUpdate(StockUpdateEntity entity) {
        if (entity == null) return null;

        StockUpdate stockUpdate = new StockUpdate(
                entity.getEmployeeId(),
                entity.getProductId(),
                entity.getUpdateType(),
                entity.getQuantity()
        );
        stockUpdate.setId(entity.getId());
        stockUpdate.setTransactionDate(entity.getDate());

        return stockUpdate;
    }
}
