package com.github.bakery.ddd.yun0.week01.domain.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseRecipe {
    private final double goldenRatio;
    private final int maxFlourTypeCount;
    private final int maxKneadingTemperature;
    private final int maxKneadingMinutes;
}
