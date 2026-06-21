package com.microservices.order.infrastructure.kafka;

import com.microservices.shared.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductEventConsumer {

    @KafkaListener(topics = "ProductCreatedEvent", groupId = "order-service-group")
    public void consume(ProductCreatedEvent event) {
        log.info("Received product event: {}", event);
    }
}

