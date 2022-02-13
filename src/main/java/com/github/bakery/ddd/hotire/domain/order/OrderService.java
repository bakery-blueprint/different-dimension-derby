package com.github.bakery.ddd.hotire.domain.order;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public void order(Order order) {
        orderRepository.save(order.ordered());
    }
}
