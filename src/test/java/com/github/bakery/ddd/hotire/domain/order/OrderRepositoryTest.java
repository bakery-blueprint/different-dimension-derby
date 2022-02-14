package com.github.bakery.ddd.hotire.domain.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void ordered() {
        orderRepository.saveAndFlush(new Order().ordered());
    }
}