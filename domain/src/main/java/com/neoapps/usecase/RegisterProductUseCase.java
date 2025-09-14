package com.neoapps.usecase;

import com.neoapps.exceptions.DomainException;
import com.neoapps.model.brand.Brand;
import com.neoapps.model.category.Category;
import com.neoapps.model.gateway.ProductRepositoryGateway;
import com.neoapps.model.product.Product;
import com.neoapps.model.supplier.Supplier;
import com.neoapps.usecase.dtos.CreateProductRequest;
import com.neoapps.usecase.dtos.CreateProductResponse;

public class RegisterProductUseCase {

    private final ProductRepositoryGateway productRepositoryGateway;

    public RegisterProductUseCase(ProductRepositoryGateway productRepositoryGateway) {
        this.productRepositoryGateway = productRepositoryGateway;
    }

    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {

        if (createProductRequest.getWholesalePrice() >= createProductRequest.getRetailPrice()) {
            throw new DomainException("Wholesale price can't be higher or equal to retail price", "WholesalePrice");
        }

        Boolean productAlreadyExist = productRepositoryGateway.existsByName(createProductRequest.getName());
        if (productAlreadyExist) {
            throw new DomainException("A product named: '" + createProductRequest.getName() + "' already exists", "ProductName");
        }

        Product product = buildProduct(createProductRequest);

        Product productSaved = productRepositoryGateway.createProduct(product);

        return new CreateProductResponse(
                productSaved.getId(),
                productSaved.getName(),
                productSaved.getDescription(),
                productSaved.getStock(),
                productSaved.getRetailPrice(),
                productSaved.getWholeSalePrice(),
                productSaved.getSupplier().getName(),
                productSaved.getBrand().getName(),
                productSaved.getCategory().getName(),
                productSaved.getCreationTime());
    }

    private Product buildProduct(CreateProductRequest createProductRequest) {
        Supplier supplier = new Supplier();
        supplier.setId(createProductRequest.getSupplierId());

        Brand brand = new Brand();
        brand.setId(createProductRequest.getBrandId());

        Category category = new Category();
        category.setId(createProductRequest.getCategoryId());

        return new Product(
                createProductRequest.getName(),
                createProductRequest.getDescription(),
                createProductRequest.getStock(),
                createProductRequest.getRetailPrice(),
                createProductRequest.getWholesalePrice(),
                createProductRequest.isActive(),
                supplier,
                brand,
                category);
    }
}
