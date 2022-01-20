package com.github.bakery.ddd.yun0.week01.domain;

import com.github.bakery.ddd.yun0.week01.domain.flour.Flour;
import com.github.bakery.ddd.yun0.week01.domain.flour.FlourType;
import com.github.bakery.ddd.yun0.week01.domain.recipe.BaseRecipe;
import org.junit.jupiter.api.Test;

import java.util.Set;

class BreadTest {
    @Test
    void prepare() {
        // given
        var recipe = new BaseRecipe(0.5, 2, 40, 15);
        var processor = new BakeryProcessor(recipe);

        // when
        var ingredients = processor.prepare(Set.of(new Flour(FlourType.RICE, 100), new Flour(FlourType.WHEAT, 100)));
        var dough = processor.knead(ingredients, 30, 5);

        // then
        System.out.println(dough);
    }
}
