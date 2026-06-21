package com.microservices.product.domain.service;

import com.microservices.product.api.dto.CreateProductRequest;
import com.microservices.product.domain.model.Product;
import com.microservices.product.domain.port.ProductRepository;
import com.microservices.shared.DomainEventPublisher;
import com.microservices.shared.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;
    private final DomainEventPublisher publisher;

    public Product create(CreateProductRequest request) {

        Objects.requireNonNull(request, "Request cannot be null");
        if (request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("Product name is required");
        }

        Product product = Product.createNew(request.name(), request.price());
        Product saved = repo.save(product);

        publisher.publish(new ProductCreatedEvent(
                saved.id(),
                saved.name(),
                saved.price()
        ));

        return saved;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }
}

