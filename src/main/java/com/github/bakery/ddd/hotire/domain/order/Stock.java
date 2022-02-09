package com.github.bakery.ddd.hotire.domain.order;

import com.github.bakery.ddd.wenmoe.domain.BreadType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Stock {
    private final BreadType breadType;
    private int totalQuantity;

    public void buy(int quantity) {
        checkAvailableBuy(quantity);
        totalQuantity -= quantity;
    }

    private void checkAvailableBuy(int quantity) {
        if (totalQuantity < quantity) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
    }

}
