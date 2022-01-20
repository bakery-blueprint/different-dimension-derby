package com.github.bakery.ddd.yun0.week01.domain;

import com.github.bakery.ddd.yun0.week01.domain.flour.Flour;
import com.github.bakery.ddd.yun0.week01.domain.recipe.BaseRecipe;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class BakeryProcessor {
    private final BaseRecipe baseRecipe;

    public Ingredients prepare(Set<Flour> flours) {
        if (flours.size() > baseRecipe.getMaxFlourTypeCount()) {
            throw new IllegalArgumentException("가루 종류가 너무 많아요!");
        }
        if (flours.stream().map(Flour::getGrams)
                .reduce((a, b) -> a / (a + b))
                .filter(ratio -> ratio < baseRecipe.getGoldenRatio())
                .isEmpty()) {
            throw new IllegalArgumentException("비율이 이상해요!");
        }

        return new Ingredients(flours);
    }

    public Dough knead(Ingredients ingredients, int temperature, int minutes) {
        if (temperature > baseRecipe.getMaxKneadingTemperature()) {
            throw new IllegalArgumentException("반죽이 푹 익어버렸어요!");
        }
        if (minutes > baseRecipe.getMaxKneadingMinutes()) {
            throw new IllegalArgumentException("반죽이 너무 단단해졌어요!");
        }
        return new Dough(ingredients);
    }
}
