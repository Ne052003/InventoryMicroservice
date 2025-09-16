package com.neoapps.model.gateway;

import com.neoapps.model.stockUpdate.StockUpdate;

import java.util.List;

public interface StockUpdateRepositoryGateway {

    void save(StockUpdate stockUpdate);

    List<StockUpdate> getByProductId(Long productId);

    List<StockUpdate> getAll();
}
