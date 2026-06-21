package com.microservices.product;

import com.microservices.product.domain.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testCreateNewProduct() {
        Product product = Product.createNew("Laptop", 999);

        assertNull(product.id());
        assertEquals("Laptop", product.name());
        assertEquals(999, product.price());
    }

    @Test
    void testProductWithId() {
        Product product = Product.withId(5L, "Mouse", 25);

        assertEquals(5L, product.id());
        assertEquals("Mouse", product.name());
        assertEquals(25, product.price());
    }

    @Test
    void testChangePrice() {
        Product product = Product.withId(1L, "Keyboard", 75);
        Product updatedProduct = product.changePrice(85);

        assertEquals(1L, updatedProduct.id());
        assertEquals("Keyboard", updatedProduct.name());
        assertEquals(85, updatedProduct.price());
    }

    @Test
    void testProductValidationNullName() {
        assertThrows(IllegalArgumentException.class, () ->
                Product.createNew(null, 100)
        );
    }

    @Test
    void testProductValidationBlankName() {
        assertThrows(IllegalArgumentException.class, () ->
                Product.createNew("   ", 100)
        );
    }

    @Test
    void testProductValidationZeroPrice() {
        assertThrows(IllegalArgumentException.class, () ->
                Product.createNew("Monitor", 0)
        );
    }

    @Test
    void testProductValidationNegativePrice() {
        assertThrows(IllegalArgumentException.class, () ->
                Product.createNew("Headphones", -50)
        );
    }
}