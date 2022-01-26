package com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Temperature;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import java.util.List;
import lombok.Getter;

@Getter
abstract public class Recipe {

    private final int fermentTime;
    private final Temperature fermentTemperature;
    private final int bakeTime;
    private final Temperature bakeTemperature;

    private final List<RecipeMainMaterial> recipeMainMaterials;
    private final List<RecipeSubMaterial> recipeSubMaterials;

    protected Recipe(int fermentTime, Temperature fermentTemperature
        , int bakeTime, Temperature bakeTemperature
        , List<RecipeMainMaterial> recipeMainMaterials, List<RecipeSubMaterial> recipeSubMaterials) {
        this.fermentTime = fermentTime;
        this.fermentTemperature = fermentTemperature;
        this.bakeTime = bakeTime;
        this.bakeTemperature = bakeTemperature;
        this.recipeMainMaterials = recipeMainMaterials;
        this.recipeSubMaterials = recipeSubMaterials;
    }

    abstract public BakingProcess getProcess(BakingStep step);
}
