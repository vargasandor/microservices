package com.microservices.product.api;

import com.microservices.product.api.dto.CreateProductRequest;
import com.microservices.product.api.dto.ProductResponse;
import com.microservices.product.domain.model.Product;
import com.microservices.product.domain.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ProductResponse create(@Valid @RequestBody CreateProductRequest request) {
        Product product = service.create(request);
        return new ProductResponse(product.id(), product.name(), product.price());
    }

    @GetMapping
    public List<ProductResponse> list() {
        return service.findAll()
                .stream()
                .map(p -> new ProductResponse(p.id(), p.name(), p.price()))
                .toList();
    }
}

