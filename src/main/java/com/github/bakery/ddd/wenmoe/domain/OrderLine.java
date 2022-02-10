package com.github.bakery.ddd.wenmoe.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Getter
@Embeddable
public class OrderLine {
    @Embedded
    private Item item;

    @Column(name = "quantity")
    private int quantity;

    public OrderLine(Item item, int quantity) {
        item.compareStock(quantity);
        this.item = item;
        this.quantity = quantity;
    }

    public Money calculateAmounts() {
        return item.getPrice().multiply(quantity);
    }
}
