package com.github.bakery.ddd.yun0.week01.domain.flour;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FlourType {
    WHEAT("밀"),
    ALMOND("아몬드"),
    BUCKWHEAT("메밀"),
    RICE("쌀");

    private final String name;
}
