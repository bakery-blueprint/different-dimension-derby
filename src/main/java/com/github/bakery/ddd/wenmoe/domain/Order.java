package com.github.bakery.ddd.wenmoe.domain;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {
    @Id
    @Column(name="order_number")
    private String orderNo;

    @ElementCollection
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Column(name = "total_amounts")
    private Money totalAmounts;

    public Order(Customer customer, List<OrderLine> orderLines) {
        this.orderNo = UUID.randomUUID().toString();;
        setOrderLines(orderLines);
        customer.canAfford(totalAmounts);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(o -> o.calculateAmounts().getValue()).sum());
    }
}
