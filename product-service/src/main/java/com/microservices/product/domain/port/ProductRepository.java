package com.microservices.product.domain.port;

import com.microservices.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    List<Product> findAll();
}
