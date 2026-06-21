package com.microservices.order.domain.model;

import com.microservices.order.domain.exceptions.InvalidOrderException;

public record Order(Long id, Long productId, int quantity) {

    public Order {
        if (productId == null) {
            throw new InvalidOrderException("productId cannot be null");
        }
        if (quantity <= 0) {
            throw new InvalidOrderException("quantity must be positive");
        }
    }

    public static Order createNew(Long productId, int quantity) {
        return new Order(null, productId, quantity);
    }

    public static Order withId(Long id, Long productId, int quantity) {
        return new Order(id, productId, quantity);
    }
}
