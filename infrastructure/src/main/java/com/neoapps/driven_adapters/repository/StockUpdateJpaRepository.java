package com.neoapps.driven_adapters.repository;

import com.neoapps.driven_adapters.entities.StockUpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockUpdateJpaRepository extends JpaRepository<StockUpdateEntity, Long> {

    List<StockUpdateEntity> findByProductId(Long id);
}
