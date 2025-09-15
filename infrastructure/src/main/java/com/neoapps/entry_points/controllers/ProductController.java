package com.neoapps.entry_points.controllers;

import com.neoapps.usecase.GetProductUseCase;
import com.neoapps.usecase.dtos.CreateProductRequest;
import com.neoapps.usecase.dtos.CreateProductResponse;
import com.neoapps.usecase.dtos.GetProductResponse;
import com.neoapps.usecase.RegisterProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final RegisterProductUseCase registerProductUseCase;
    private final GetProductUseCase getProductUseCase;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request) {

        CreateProductResponse responseProduct = registerProductUseCase.createProduct(request);
        return ResponseEntity.ok(responseProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> getProductById(@PathVariable Long id) {

        Optional<GetProductResponse> getProductResponse = getProductUseCase.getProductById(id);

        return getProductResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
