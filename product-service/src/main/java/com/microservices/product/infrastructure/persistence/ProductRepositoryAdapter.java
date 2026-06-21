package com.microservices.product.infrastructure.persistence;

import com.microservices.product.domain.model.Product;
import com.microservices.product.domain.port.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final SpringDataProductRepository jpaRepo;

    public ProductRepositoryAdapter(SpringDataProductRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.id(), product.name(), product.price());
        ProductEntity saved = jpaRepo.save(entity);
        return Product.withId(saved.getId(), saved.getName(), saved.getPrice());
    }

    @Override
    public List<Product> findAll() {
        return jpaRepo.findAll()
                .stream()
                .map(e -> Product.withId(e.getId(), e.getName(), e.getPrice()))
                .toList();
    }
}
