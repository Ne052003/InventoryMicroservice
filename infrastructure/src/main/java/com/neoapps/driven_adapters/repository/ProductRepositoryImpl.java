package com.neoapps.driven_adapters.repository;

import com.neoapps.driven_adapters.entities.ProductEntity;
import com.neoapps.driven_adapters.mappers.ProductMapper;
import com.neoapps.model.gateway.ProductRepositoryGateway;
import com.neoapps.model.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryGateway {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<Product> getProductById(Long id) {

        Optional<ProductEntity> optProductEntity = productJpaRepository.findById(id);

        if (optProductEntity.isEmpty()) {
            return Optional.empty();
        }

        return optProductEntity.map(productMapper::toProduct);
    }

    @Override
    public Boolean existsByName(String name) {
        return productJpaRepository.existsByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {

        if (product == null) {
            return null;
        }

        ProductEntity productEntity = productMapper.toProductEntity(product);

        ProductEntity savedEntity = productJpaRepository.save(productEntity);

        ProductEntity fullEntity = productJpaRepository.findByIdWithRelations(savedEntity.getId()).orElseThrow();

        return productMapper.toProduct(fullEntity);
    }
}
