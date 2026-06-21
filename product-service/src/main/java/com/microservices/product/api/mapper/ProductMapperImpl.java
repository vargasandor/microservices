package com.microservices.product.api.mapper;

import com.microservices.product.api.dto.ProductResponse;
import org.springframework.stereotype.Component;
import com.microservices.product.domain.model.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.id(),
                product.name(),
                product.price()
        );
    }
}

