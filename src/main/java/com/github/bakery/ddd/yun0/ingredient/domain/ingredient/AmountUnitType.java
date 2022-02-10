package com.github.bakery.ddd.yun0.ingredient.domain.ingredient;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AmountUnitType {
    GRAM("g"),
    MILLILITER("ml"),
    QUANTITY("p")
    ;

    private final String unit;
}
