package com.github.bakery.ddd.yun0.bread.infrastructure.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseRecipe {
    private final double goldenRatio;
    private final int maxFlourTypeCount;
    private final int maxKneadingTemperature;
    private final int maxKneadingMinutes;
    private final int maxRipeningTemperature;
    private final int maxRipeningMinutes;
    private final int maxBakingTemperature;
    private final int maxBakingMinutes;
}
