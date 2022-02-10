package com.github.bakery.ddd.yun0.bread.domain.recipe;

import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;

public interface RecipeFactory {
    Recipe getRecipe(BreadType breadType);
}
