package com.microservices.product.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
        @NotNull String name,
        @Min(1) int price)
{}

