package com.github.bakery.ddd.wenmoe.domain;

import org.springframework.util.CollectionUtils;

import java.util.Set;

public class Dough {
    private int minute; // 반죽 시간..?
    private Set<MainIngredient> mainIngredients;

    public Dough(Set<MainIngredient> mainIngredients) {
        if (CollectionUtils.isEmpty(mainIngredients) || mainIngredients.size() > 2) {
            throw new IllegalStateException();
        }

        this.mainIngredients = mainIngredients;
        this.minute = 0;
    }
}
