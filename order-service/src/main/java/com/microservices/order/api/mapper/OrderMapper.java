package com.microservices.order.api.mapper;

import com.microservices.order.api.dto.OrderResponse;
import com.microservices.order.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponse toResponse(Order o) {
        return new OrderResponse(o.id(), o.productId(), o.quantity());
    }
}

