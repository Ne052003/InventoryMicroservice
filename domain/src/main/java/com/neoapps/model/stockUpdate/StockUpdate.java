package com.neoapps.model.stockUpdate;

import com.neoapps.model.product.Stock;

import java.time.LocalDateTime;

public class StockUpdate {

    private Long id;
    private Long employeeId;
    private Long productId;
    private TransactionType transactionType;
    private Stock quantity;
    private LocalDateTime transactionDate;

    public StockUpdate(Long employeeId, Long productId, TransactionType transactionType, Integer quantity) {
        this.employeeId = employeeId;
        this.productId = productId;
        this.transactionType = transactionType;
        this.quantity = new Stock(quantity);
        this.transactionDate = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Integer getQuantity() {
        return this.quantity.value();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = new Stock(quantity);
    }

    public LocalDateTime getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
