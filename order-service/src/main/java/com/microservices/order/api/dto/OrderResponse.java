package com.microservices.order.api.dto;

public record OrderResponse(Long id, Long productId, int quantity) {}

