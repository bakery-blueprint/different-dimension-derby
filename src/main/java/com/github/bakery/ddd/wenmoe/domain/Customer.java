package com.github.bakery.ddd.wenmoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
    private String customerId;
    private Money money;

    // 고객은 자신이 가진 돈에서 빵 구입이 가능하다.
    public boolean canAfford(Money totalAmounts) {
        return money.getValue() >= totalAmounts.getValue();
    }
}
