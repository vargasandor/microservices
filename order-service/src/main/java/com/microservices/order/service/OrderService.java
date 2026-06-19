package com.microservices.order.service;

import com.microservices.order.model.Order;
import com.microservices.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
}


