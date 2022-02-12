package com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant;

import java.util.List;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.DoughWater;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.Material;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;

public class CroissantFermentBakingProcess extends CroissantBakingProcess {

    public CroissantFermentBakingProcess() {
        super(BakingStep.FERMENT);
    }

    @Override
    public Bread process(Recipe breadRecipe, List<Material> mainMaterial, List<Material> subMaterial) {
        DoughWater doughWater = getDoughWater(subMaterial);
        verifyUsingDoughWater(doughWater);
        
        return new Bread(getBreadName(), getStep());
    }

    private void verifyUsingDoughWater(final DoughWater doughWater) {
        if ((doughWater.getTemperature().getValue() > 40.0f && "C".equals(doughWater.getTemperature().getUnit())
             || doughWater.getTemperature().getValue() > 104.0f && "F".equals(doughWater.getTemperature().getUnit()))) {
            throw new IllegalArgumentException("The temperature should be below 40C degrees.");
        }
    }

    private DoughWater getDoughWater(final List<Material> subMaterial) {
        return subMaterial.stream()
                          .filter(it -> it.getClass().equals(DoughWater.class))
                          .map(it -> (DoughWater) it)
                          .findAny()
                          .orElseThrow(() -> new IllegalArgumentException("Dough Water does not exist in the Sub Material list."));
    }
}
