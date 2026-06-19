package com.microservices.product.service;

import com.microservices.product.kafka.ProductEventProducer;
import com.microservices.product.model.Product;
import com.microservices.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductEventProducer producer;

    public ProductService(ProductRepository repository, ProductEventProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    public Product create(Product product) {
        Product saved = repository.save(product);
        producer.sendProductCreatedEvent(saved);
        return saved;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }
}


