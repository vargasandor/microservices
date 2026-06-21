package com.microservices.product.domain.model;

public record Product(Long id, String name, int price) {

    public Product {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
    }

    public static Product createNew(String name, int price) {
        return new Product(null, name, price);
    }

    public static Product withId(Long id, String name, int price) {
        return new Product(id, name, price);
    }

    public Product changePrice(int newPrice) {
        return new Product(this.id, this.name, newPrice);
    }
}
