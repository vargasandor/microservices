package com.microservices.order.domain.port;

import com.microservices.order.domain.model.Order;

import java.util.List;

public interface OrderRepository {

    Order save(Order order);

    List<Order> findAll();
}
