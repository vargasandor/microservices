package com.microservices.order.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    private final Long productId;
    private final int quantity;

    public OrderEntity(Long id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

}
