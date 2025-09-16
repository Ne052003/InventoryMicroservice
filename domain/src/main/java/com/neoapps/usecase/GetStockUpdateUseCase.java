package com.neoapps.usecase;

import com.neoapps.exceptions.DomainException;
import com.neoapps.model.gateway.ProductRepositoryGateway;
import com.neoapps.model.gateway.StockUpdateRepositoryGateway;
import com.neoapps.model.stockUpdate.StockUpdate;

import java.util.List;

public class GetStockUpdateUseCase {

    private final StockUpdateRepositoryGateway stockUpdateRepositoryGateway;
    private final ProductRepositoryGateway productRepositoryGateway;

    public GetStockUpdateUseCase(StockUpdateRepositoryGateway stockUpdateRepositoryGateway, ProductRepositoryGateway productRepositoryGateway) {
        this.stockUpdateRepositoryGateway = stockUpdateRepositoryGateway;
        this.productRepositoryGateway = productRepositoryGateway;
    }

    public List<StockUpdate> getByProductId(Long productId) {
        if (productId == null) throw new DomainException("Id can't be null", "ProductId");

        if (!productRepositoryGateway.existsById(productId)) {
            throw new DomainException("A product with id " + productId + " does not exist", "ProductId");
        }

        return stockUpdateRepositoryGateway.getByProductId(productId);

    }

    public List<StockUpdate> getAll() {
        return stockUpdateRepositoryGateway.getAll();
    }
}
