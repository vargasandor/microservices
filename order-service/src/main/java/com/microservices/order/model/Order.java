package com.microservices.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Long productId;
    private String productName;
    private int quantity;

}

