package com.microservices.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

}
