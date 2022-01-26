package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.CroissantRecipe;
import java.util.List;
import org.junit.jupiter.api.Test;

class BakingTest {

    @Test
    public void tesT() {
        Baking baking = new Baking(
            new CroissantRecipe(
                40, new Temperature(10L, "C")
                , 40, new Temperature(50L, "C")
                , List.of(), List.of())
            , List.of()
            , List.of());

        baking.processNextStep(List.of(), List.of());
        baking.processNextStep(List.of(), List.of());


    }

}