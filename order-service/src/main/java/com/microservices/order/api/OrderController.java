package com.microservices.order.api;

import com.microservices.order.api.dto.CreateOrderRequest;
import com.microservices.order.api.dto.OrderResponse;
import com.microservices.order.api.mapper.OrderMapper;
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
    private final OrderMapper mapper;

    @PostMapping
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest request) {
        Order order = service.create(request);
        return mapper.toResponse(service.create(request));
    }

    @GetMapping
    public List<OrderResponse> list() {
        return service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}

