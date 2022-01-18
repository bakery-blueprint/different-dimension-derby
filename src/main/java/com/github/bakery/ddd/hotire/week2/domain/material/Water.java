package com.github.bakery.ddd.hotire.week2.domain.material;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Water implements Material {
    private final Double temperature;
}
