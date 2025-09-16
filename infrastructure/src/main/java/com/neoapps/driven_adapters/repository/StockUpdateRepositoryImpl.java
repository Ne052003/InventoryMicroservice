package com.neoapps.driven_adapters.repository;

import com.neoapps.driven_adapters.entities.StockUpdateEntity;
import com.neoapps.driven_adapters.exceptions.RepositoryException;
import com.neoapps.driven_adapters.mappers.StockUpdateMapper;
import com.neoapps.model.gateway.StockUpdateRepositoryGateway;
import com.neoapps.model.stockUpdate.StockUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockUpdateRepositoryImpl implements StockUpdateRepositoryGateway {

    private final StockUpdateJpaRepository stockUpdateJpaRepository;
    private final StockUpdateMapper stockUpdateMapper;

    @Override
    public void save(StockUpdate stockUpdate) {

        StockUpdateEntity stockUpdateEntity = stockUpdateMapper.toEntity(stockUpdate);
        StockUpdateEntity stockUpdateEntitySaved = stockUpdateJpaRepository.save(stockUpdateEntity);

        if (!stockUpdateEntitySaved.getQuantity().equals(stockUpdate.getQuantity())) {
            throw new RepositoryException("The stock was not successfully updated", "StockUpdate");
        }
    }

    @Override
    public List<StockUpdate> getByProductId(Long productId) {

        List<StockUpdateEntity> stockUpdateEntities = stockUpdateJpaRepository.findByProductId(productId);
        return stockUpdateEntities.stream().map(stockUpdateMapper::toStockUpdate).toList();
    }

    @Override
    public List<StockUpdate> getAll() {
        return stockUpdateJpaRepository.findAll().stream().map(stockUpdateMapper::toStockUpdate).toList();
    }
}
