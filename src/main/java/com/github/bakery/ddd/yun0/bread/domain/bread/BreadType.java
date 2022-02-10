package com.github.bakery.ddd.yun0.bread.domain.bread;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BreadType {
    CROISSANT(1000),
    SOBORO(1000),
    PIZZA(1000),
    MACAROON(1000);

    private final int price;
}
