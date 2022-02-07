package com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Temperature;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant.CroissantDecorationBakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant.CroissantDoughBakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant.CroissantFermentBakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant.CroissantPrepareBakingProcess;
import java.util.ArrayList;
import java.util.List;

public class CroissantRecipe extends Recipe {

    List<BakingProcess> processes;

    public CroissantRecipe(int fermentTime, Temperature fermentTemperature
        , int bakeTime, Temperature bakeTemperature
        , List<RecipeMainMaterial> recipeMainMaterials, List<RecipeSubMaterial> recipeSubMaterials) {
        super(fermentTime, fermentTemperature, bakeTime, bakeTemperature, recipeMainMaterials, recipeSubMaterials);
        processes = new ArrayList<>();
        processes.add(new CroissantPrepareBakingProcess());
        processes.add(new CroissantDoughBakingProcess());
        processes.add(new CroissantFermentBakingProcess());
        processes.add(new CroissantDecorationBakingProcess());
    }

    @Override
    public BakingProcess getProcess(BakingStep step) {
        return processes.stream()
            .filter(it -> step.equals(it.getStep()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("정확하지 않은 단계입니다."));
    }
}
