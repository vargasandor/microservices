package com.microservices.shared;

public interface DomainEventPublisher {
    void publish(Object event);
}

