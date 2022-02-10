package com.github.bakery.ddd.yun0.bread.infrastructure.processor;

import com.github.bakery.ddd.yun0.bread.domain.processor.Processor;
import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import com.github.bakery.ddd.yun0.bread.domain.recipe.Recipe;

public class CroissantBakingProcessor implements Processor {
    @Override
    public Bread process(Bread origin, Recipe recipe) {
        if (BreadType.CROISSANT.equals(origin.getType())) {
            throw new IllegalArgumentException("크로아상이 아닙니다.");
        }
        // process
        return origin;
    }
}
