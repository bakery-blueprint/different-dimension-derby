package com.github.bakery.ddd.wenmoe.application;


import com.github.bakery.ddd.wenmoe.domain.BreadType;
import com.github.bakery.ddd.wenmoe.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {
    private List<OrderItem> orderItems;
    private Customer customer;

    @AllArgsConstructor
    @Getter
    public class OrderItem {
        private String id;
        private BreadType breadType;
        private int quantity;
    }
}


