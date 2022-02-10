package com.github.bakery.ddd.yun0.bread.infrastructure.recipe;

import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import com.github.bakery.ddd.yun0.bread.domain.recipe.Recipe;
import com.github.bakery.ddd.yun0.bread.domain.recipe.RecipeFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultRecipeFactory implements RecipeFactory {
    @Override
    public Recipe getRecipe(BreadType breadType) {
        if (BreadType.CROISSANT.equals(breadType)) {
            return new Recipe(0.5, 2, 40, 15, 40, 15, 40, 15);
        }
        return null;
    }
}
