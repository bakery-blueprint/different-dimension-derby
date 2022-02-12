package com.github.bakery.ddd.wenmoe.application;

import com.github.bakery.ddd.wenmoe.domain.*;
import com.github.bakery.ddd.wenmoe.infra.repository.ItemRepository;
import com.github.bakery.ddd.wenmoe.infra.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public void placeOrder(OrderRequest request) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (OrderRequest.OrderItem orderItem : request.getOrderItems()) {
            Item item = itemRepository.findById(orderItem.getId());
            if (item == null) {
                throw new IllegalArgumentException();
            }
            orderLines.add(new OrderLine(item, orderItem.getQuantity()));
        }

        Order order = new Order(request.getCustomer(), orderLines);
        orderRepository.save(order);
    }
}
