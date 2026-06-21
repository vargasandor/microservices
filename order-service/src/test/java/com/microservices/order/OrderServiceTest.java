package com.microservices.order;

import com.microservices.order.api.dto.CreateOrderRequest;
import com.microservices.order.domain.model.Order;
import com.microservices.order.domain.port.OrderRepository;
import com.microservices.order.domain.service.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Test
    void createOrder_savesOrder() {
        // Arrange
        OrderRepository repo = mock(OrderRepository.class);
        OrderService service = new OrderService(repo);

        Order expected = Order.withId(1L, 10L, 2);
        when(repo.save(any())).thenReturn(expected);

        // Act
        Order result = service.create(new CreateOrderRequest(10L, 2));

        // Assert
        assertEquals(1L, result.id());
        assertEquals(10L, result.productId());
        assertEquals(2, result.quantity());

        verify(repo).save(any());
    }

}
