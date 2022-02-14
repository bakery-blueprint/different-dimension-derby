package com.github.bakery.ddd.hotire.domain.order;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Optional<Product> findOneOrderByExpirationDate() {
        return Optional.empty();
    }

    public Product save(Product product) {
        return product;
    }
}
