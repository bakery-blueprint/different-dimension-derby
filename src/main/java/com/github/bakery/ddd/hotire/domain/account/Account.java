package com.github.bakery.ddd.hotire.domain.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.github.bakery.ddd.hotire.domain.billing.Money;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private Money balance;

    public void buy(Money price) {
        checkAvailableBuy(price);
        getBalance().setValue(getBalance().getValue().subtract(price.getValue()));
    }

    private void checkAvailableBuy(Money price) {
        if (getBalance().getValue().compareTo(price.getValue()) >= 0) {
            throw new IllegalStateException("잔고가 부족합니다. ");
        }
    }

} 
