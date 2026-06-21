package com.microservices.shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCreatedEventTest {

    @Test
    void testProductCreatedEventCreation() {
        Long id = 1L;
        String name = "Test Product";
        int price = 100;

        ProductCreatedEvent event = new ProductCreatedEvent(id, name, price);

        assertEquals(id, event.id());
        assertEquals(name, event.name());
        assertEquals(price, event.price());
    }

    @Test
    void testProductCreatedEventWithDifferentValues() {
        ProductCreatedEvent event = new ProductCreatedEvent(2L, "Another Product", 250);

        assertEquals(2L, event.id());
        assertEquals("Another Product", event.name());
        assertEquals(250, event.price());
    }
}