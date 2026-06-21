package com.microservices.product.api.mapper;

import com.microservices.product.api.dto.ProductResponse;
import com.microservices.product.domain.model.Product;

public interface ProductMapper {
    ProductResponse toResponse(Product product);
}

