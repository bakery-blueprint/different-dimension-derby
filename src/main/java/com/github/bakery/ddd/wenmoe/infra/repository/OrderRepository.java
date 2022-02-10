package com.github.bakery.ddd.wenmoe.infra.repository;

import com.github.bakery.ddd.wenmoe.domain.Order;

public interface OrderRepository {
    void save(Order order);
}
