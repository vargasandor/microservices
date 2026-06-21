package com.microservices.order.infrastructure.persistence;

import com.microservices.order.domain.model.Order;
import com.microservices.order.domain.port.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {

    private final SpringDataOrderRepository jpaRepo;

    public OrderRepositoryAdapter(SpringDataOrderRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = new OrderEntity(order.id(), order.productId(), order.quantity());
        OrderEntity saved = jpaRepo.save(entity);
        return Order.withId(saved.getId(), saved.getProductId(), saved.getQuantity());
    }

    @Override
    public List<Order> findAll() {
        return jpaRepo.findAll()
                .stream()
                .map(e -> Order.withId(e.getId(), e.getProductId(), e.getQuantity()))
                .toList();
    }
}
