package com.neoapps.usecase.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateProductResponse {

    private Long id;
    private String name;
    private String description;
    private Integer stock;
    private BigDecimal retailPrice;
    private BigDecimal wholeSalePrice;
    private String supplierName;
    private String brandName;
    private String categoryName;
    private LocalDateTime creationTime;

    public CreateProductResponse(
            Long id,
            String name,
            String description,
            Integer stock,
            BigDecimal retailPrice,
            BigDecimal wholeSalePrice,
            String supplierName,
            String brandName,
            String categoryName,
            LocalDateTime creationTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.retailPrice = retailPrice;
        this.wholeSalePrice = wholeSalePrice;
        this.brandName = brandName;
        this.supplierName = supplierName;
        this.categoryName = categoryName;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public BigDecimal getWholeSalePrice() {
        return wholeSalePrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
