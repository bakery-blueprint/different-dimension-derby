package com.github.bakery.ddd.wenmoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Money {
    private int value;

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
}
