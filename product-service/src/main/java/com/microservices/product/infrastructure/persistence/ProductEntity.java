package com.microservices.product.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

    protected ProductEntity() {}

    public ProductEntity(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}

