package com.microservices.order.api;

import com.microservices.order.api.dto.CreateOrderRequest;
import com.microservices.order.api.dto.OrderResponse;
import com.microservices.order.domain.model.Order;
import com.microservices.order.domain.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
//Parameters checks: NotNull, etc
    @PostMapping
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest request) {
        Order order = service.create(request);
        return new OrderResponse(order.id(), order.productId(), order.quantity());
    }

    @GetMapping
    public List<OrderResponse> list() {
        return service.findAll()
                .stream()
                .map(o -> new OrderResponse(o.id(), o.productId(), o.quantity()))
                .toList();
    }
}

