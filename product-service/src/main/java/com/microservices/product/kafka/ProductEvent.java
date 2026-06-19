package com.microservices.product.kafka;

public record ProductEvent(Long id, String name, int price) {}
