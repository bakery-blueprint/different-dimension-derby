package com.github.bakery.ddd.hotire.domain.order;

import com.github.bakery.ddd.hotire.domain.billing.Money;
import com.github.bakery.ddd.hotire.domain.bread.Bread;

import lombok.Data;

@Data
public class Product {
    private Bread bread;
    private Money price;
}
