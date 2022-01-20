package com.github.bakery.ddd.yun0.week01.domain.flour;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@AllArgsConstructor
public class Flour {
    @EqualsAndHashCode.Include
    private final FlourType type;
    private final int grams;

    @Override
    public String toString() {
        return type.getName() + "가루 " + grams + "g";
    }
}
