package com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant;

import java.util.List;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.factory.BreadExpirationDateFactory;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.Material;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;

public class CroissantDecorationBakingProcess extends CroissantBakingProcess {

    public CroissantDecorationBakingProcess() {
        super(BakingStep.DECORATION);
    }

    @Override
    public Bread process(Recipe breadRecipe, List<Material> mainMaterial, List<Material> subMaterial) {
        return new Bread(getBreadName(), getStep(), BreadExpirationDateFactory.getExpirationDate(getBreadName()));
    }
}
