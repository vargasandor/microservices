package com.microservices.order.domain.service;

import com.microservices.order.api.dto.CreateOrderRequest;
import com.microservices.order.domain.model.Order;
import com.microservices.order.domain.port.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order create(CreateOrderRequest request) {

        /* to be implemented
        if (!productExists(request.productId())) {
            throw new ProductNotFoundException(request.productId());
        }

        if (!hasStock(request.productId(), request.quantity())) {
            throw new OutOfStockException(request.productId());
        }
         */

        Order order = Order.createNew(request.productId(), request.quantity());
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}

