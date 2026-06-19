package com.microservices.product.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.microservices.product.model.Product;

@Service
public class ProductEventProducer {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    public ProductEventProducer(KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProductCreatedEvent(Product product) {
        ProductEvent event = new ProductEvent(
                product.getId(),
                product.getName(),
                product.getPrice()
        );

        kafkaTemplate.send("product-events", event);
    }
}


