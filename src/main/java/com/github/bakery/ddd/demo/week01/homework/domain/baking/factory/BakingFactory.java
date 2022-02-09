package com.github.bakery.ddd.demo.week01.homework.domain.baking.factory;

import java.util.List;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Baking;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Temperature;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.CroissantRecipe;

public class BakingFactory {

    public static Baking createBaking(String breadName) {

        if (breadName.equals("Croissant")) {
            return new Baking(
                    new CroissantRecipe(40, new Temperature(40, "C"), 40, new Temperature(40, "C"), List.of(), List.of()),
                    List.of(),
                    List.of()
            );
        } else {
            throw new IllegalArgumentException("Bread that cannot be made.");
        }
    }
}
