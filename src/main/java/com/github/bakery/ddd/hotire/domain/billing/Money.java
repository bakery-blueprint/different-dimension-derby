package com.github.bakery.ddd.hotire.domain.billing;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Money {
    private BigDecimal value;
}
