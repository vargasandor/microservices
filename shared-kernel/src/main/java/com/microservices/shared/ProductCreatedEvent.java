package com.microservices.shared;

public record ProductCreatedEvent(Long id, String name, int price) {}

