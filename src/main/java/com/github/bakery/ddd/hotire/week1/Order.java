package com.github.bakery.ddd.hotire.week1;

import java.util.List;

public interface Order {
    OrderState getOrderState();

    List<OrderLine> getOrderLines();

    int getTotalAmounts();
}
