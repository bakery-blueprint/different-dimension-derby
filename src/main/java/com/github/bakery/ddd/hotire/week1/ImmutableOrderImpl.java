package com.github.bakery.ddd.hotire.week1;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class ImmutableOrderImpl implements Order {
    @Getter
    private final OrderState orderState;
    private final List<OrderLine> orderLines;
    @Getter
    private final int totalAmounts;

    public ImmutableOrderImpl(final List<OrderLine> orderLines, final OrderState orderState) {
        this.orderLines = List.copyOf(orderLines);
        this.totalAmounts = calculateTotalAmount(orderLines);
        this.orderState = orderState;
    }

    private int calculateTotalAmount(final List<OrderLine> orderLines) {
        return orderLines.stream().mapToInt(OrderLine::getAmounts).sum();
    }

    @Override
    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
    }

    // verify Validation Service를 따로 생성해서 사용하는게.. 추후에 더 좋은 케이스가 많더라..
    private void verifyAtLeastOneOrMoreOrderLines(final List<OrderLine> orderLines) {

    }
}
