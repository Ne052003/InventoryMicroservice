package com.neoapps.usecase;

import com.neoapps.exceptions.DomainException;
import com.neoapps.model.gateway.ProductRepositoryGateway;
import com.neoapps.model.gateway.StockUpdateRepositoryGateway;
import com.neoapps.model.product.Product;
import com.neoapps.model.stockUpdate.StockUpdate;
import com.neoapps.model.stockUpdate.TransactionType;
import com.neoapps.usecase.dtos.UpdateProductStockRequest;

public class UpdateProductStockUseCase {

    private final ProductRepositoryGateway productRepositoryGateway;
    private final StockUpdateRepositoryGateway stockUpdateRepositoryGateway;

    public UpdateProductStockUseCase(ProductRepositoryGateway productRepositoryGateway, StockUpdateRepositoryGateway stockUpdateRepositoryGateway) {
        this.productRepositoryGateway = productRepositoryGateway;
        this.stockUpdateRepositoryGateway = stockUpdateRepositoryGateway;
    }

    public void updateProductStock(UpdateProductStockRequest request) {
        if (request == null) {
            throw new DomainException("Request can't be null", "UpdateStockProductRequest");
        }

        Product product = productRepositoryGateway.getProductById(request.getProductId())
                .orElseThrow(() -> new DomainException("A product with id " + request.getProductId() + " does not exist", "ProductId"));


        boolean isCurrentStockLower = product.getStock() < request.getQuantity();

        TransactionType transactionType = isCurrentStockLower ? TransactionType.INPUT : TransactionType.OUTPUT;

        StockUpdate stockUpdate = new StockUpdate(request.getEmployeeId(), request.getProductId(), transactionType, request.getQuantity());

        product.updateStock(request.getQuantity());
        productRepositoryGateway.updateProduct(product);
        stockUpdateRepositoryGateway.save(stockUpdate);

    }
}
