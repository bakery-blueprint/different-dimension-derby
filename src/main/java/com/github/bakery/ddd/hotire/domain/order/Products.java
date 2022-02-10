package com.github.bakery.ddd.hotire.domain.order;

import static java.util.stream.Collectors.toSet;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.github.bakery.ddd.hotire.domain.billing.Money;
import com.github.bakery.ddd.hotire.domain.bread.Bread;
import com.github.bakery.ddd.hotire.domain.bread.BreadType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Products {
    private final List<Product> products;

    public Set<BreadType> getBreadTypes() {
        return products.stream()
                       .map(Product::getBread)
                       .map(Bread::getBreadType)
                       .collect(toSet());
    }

    public int getQuantity() {
        return products.size();
    }

    public BigDecimal totalPrice() {
        return products.stream()
                       .map(Product::getPrice)
                       .map(Money::getValue)
                       .reduce(BigDecimal::add)
                       .orElse(BigDecimal.ZERO);
    }


}
