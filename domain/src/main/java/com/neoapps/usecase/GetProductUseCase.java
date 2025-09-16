package com.neoapps.usecase;

import com.neoapps.model.gateway.ProductRepositoryGateway;
import com.neoapps.model.product.Product;
import com.neoapps.usecase.dtos.GetProductResponse;

import java.util.List;
import java.util.Optional;

public class GetProductUseCase {
    private final ProductRepositoryGateway productRepository;

    public GetProductUseCase(ProductRepositoryGateway productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<GetProductResponse> getProductById(Long id) {

        Optional<Product> productOpt = productRepository.getProductById(id);
        if (productOpt.isEmpty()) {
            return Optional.empty();
        }

        return productOpt.map(product -> new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStock(),
                product.getRetailPrice(),
                product.getWholeSalePrice(),
                product.getSupplier().getName(),
                product.getBrand().getName(),
                product.getCategory().getName(),
                product.getCreationTime()));
    }

    public List<GetProductResponse> getAll() {
        return productRepository.getAllProducts().stream()
                .map(product -> new GetProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getStock(),
                        product.getRetailPrice(),
                        product.getWholeSalePrice(),
                        product.getSupplier().getName(),
                        product.getBrand().getName(),
                        product.getCategory().getName(),
                        product.getCreationTime()))
                .toList();
    }
}
