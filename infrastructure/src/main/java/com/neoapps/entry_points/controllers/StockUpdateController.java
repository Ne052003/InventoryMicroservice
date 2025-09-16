package com.neoapps.entry_points.controllers;

import com.neoapps.model.stockUpdate.StockUpdate;
import com.neoapps.usecase.GetStockUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stockupdates")
@RequiredArgsConstructor
public class StockUpdateController {
    private final GetStockUpdateUseCase getStockUpdateUseCase;

    @GetMapping
    public ResponseEntity<List<StockUpdate>> getAll() {
        return ResponseEntity.ok(getStockUpdateUseCase.getAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<StockUpdate>> getByProductId(@PathVariable Long productId) {
        List<StockUpdate> stockUpdates = getStockUpdateUseCase.getByProductId(productId);
        return ResponseEntity.ok(stockUpdates);
    }
}
