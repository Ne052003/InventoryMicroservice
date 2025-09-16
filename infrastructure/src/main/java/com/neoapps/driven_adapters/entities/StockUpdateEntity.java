package com.neoapps.driven_adapters.entities;

import com.neoapps.model.stockUpdate.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_updates")
@Getter
@Setter
@NoArgsConstructor
public class StockUpdateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_update_id")
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Enumerated(EnumType.STRING)
    @Column(name = "update_type", nullable = false)
    private TransactionType updateType;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer quantity;

    public StockUpdateEntity(Long employeeId, Long product, TransactionType updateType, LocalDateTime date, Integer quantity) {
        this.employeeId = employeeId;
        this.productId = product;
        this.updateType = updateType;
        this.date = date;
        this.quantity = quantity;
    }
}
