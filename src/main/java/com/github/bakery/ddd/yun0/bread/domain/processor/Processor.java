package com.github.bakery.ddd.yun0.bread.domain.processor;

import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import com.github.bakery.ddd.yun0.bread.domain.recipe.Recipe;

public interface Processor {
    Bread process(Bread origin, Recipe recipe);
}
