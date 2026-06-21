package com.microservices.product.infrastructure.kafka;

import com.microservices.shared.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaDomainEventPublisher implements DomainEventPublisher {

    private final KafkaTemplate<String, Object> template;

    public KafkaDomainEventPublisher(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    @Override
    public void publish(Object event) {
        String topic = event.getClass().getSimpleName();
        template.send(topic, event);
    }
}
