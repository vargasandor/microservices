package com.microservices.order.kafka;

public record ProductEvent(Long id, String name, int price) {}

