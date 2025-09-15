package com.neoapps.driven_adapters.repository;

import com.neoapps.driven_adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT p FROM ProductEntity p " +
            "JOIN FETCH p.supplier " +
            "JOIN FETCH p.brand " +
            "JOIN FETCH p.category " +
            "WHERE p.id = :id")
    Optional<ProductEntity> findByIdWithRelations(@Param("id") Long id);

    Boolean existsByName(String name);
}
