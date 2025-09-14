package com.neoapps.model.gateway;

import com.neoapps.model.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryGateway {

    Optional<Product> getProductById(Long id);

    Boolean existsByName(String name);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
