package com.microservices.order;

import org.junit.jupiter.api.Test;
import com.microservices.order.domain.model.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testCreateNewOrder() {
        Order order = Order.createNew(1L, 5);

        assertNull(order.id());
        assertEquals(1L, order.productId());
        assertEquals(5, order.quantity());
    }

    @Test
    void testOrderWithId() {
        Order order = Order.withId(10L, 2L, 3);

        assertEquals(10L, order.id());
        assertEquals(2L, order.productId());
        assertEquals(3, order.quantity());
    }

    @Test
    void testOrderValidationNullProductId() {
        assertThrows(IllegalArgumentException.class, () ->
                Order.createNew(null, 5)
        );
    }

    @Test
    void testOrderValidationNegativeQuantity() {
        assertThrows(IllegalArgumentException.class, () ->
                Order.createNew(1L, 0)
        );
    }

    @Test
    void testOrderValidationZeroQuantity() {
        assertThrows(IllegalArgumentException.class, () ->
                Order.createNew(1L, -1)
        );
    }
}