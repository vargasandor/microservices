package com.microservices.order.domain.model;

public record Order(Long id, Long productId, int quantity) {

    public Order {
        if (productId == null) {
            throw new IllegalArgumentException("productId cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must be positive");
        }
    }

    public static Order createNew(Long productId, int quantity) {
        return new Order(null, productId, quantity);
    }

    public static Order withId(Long id, Long productId, int quantity) {
        return new Order(id, productId, quantity);
    }
}
