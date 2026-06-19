package com.microservices.order.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventConsumer {

    @KafkaListener(topics = "product-events", groupId = "order-service-group")
    public void consume(ProductEvent event) {
        System.out.println("Received product event: " + event);
    }
}


