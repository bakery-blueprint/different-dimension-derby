package com.github.bakery.ddd.hotire.domain.account;

import com.github.bakery.ddd.hotire.domain.billing.Billing;
import com.github.bakery.ddd.hotire.domain.billing.Money;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Account {
    private final Long id;
    private final String name;
    private final String address;
    private final Billing billing;

    public void buy(Money price) {
        checkAvailableBuy(price);
        billing.getBalance().setValue(billing.getBalance().getValue().subtract(price.getValue()));
    }

    private void checkAvailableBuy(Money price) {
        if (billing.getBalance().getValue().compareTo(price.getValue()) >= 0) {
            throw new IllegalStateException("잔고가 부족합니다. ");
        }
    }

} 
