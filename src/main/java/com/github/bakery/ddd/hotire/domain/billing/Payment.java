package com.github.bakery.ddd.hotire.domain.billing;


import java.math.BigDecimal;

import com.github.bakery.ddd.hotire.domain.order.Order;

import lombok.Data;

@Data
public class Payment {
    private Long accountId;
    private Order order;
    private Money price;

    public Payment doSale(BigDecimal bigDecimal) {
        price.setValue(getPrice().getValue().multiply(bigDecimal));
        return this;
    }
}
