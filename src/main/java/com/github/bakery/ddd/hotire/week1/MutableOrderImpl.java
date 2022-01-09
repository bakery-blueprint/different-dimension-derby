package com.github.bakery.ddd.hotire.week1;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class MutableOrderImpl implements MutableOrder {

    @Getter
    private OrderState orderState;

    private List<OrderLine> orderLines;

    @Override
    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
    }

    @Override
    public int getTotalAmounts() {
        return orderLines.stream().mapToInt(OrderLine::getAmounts).sum();
    }

    public MutableOrder addOrderLine(final OrderLine orderLine) {
        orderLines.add(orderLine);
        return this;
    }

    public MutableOrder cancel() {
        this.orderState = OrderState.CANCELED;
        return this;
    }
}
