package com.github.bakery.ddd.hotire.domain.billing;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class Money {
    private final BigDecimal value;
}
