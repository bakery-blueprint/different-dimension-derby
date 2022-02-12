package com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.MainMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.Material;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.RecipeMainMaterial;

public class CroissantPrepareBakingProcess extends CroissantBakingProcess {

    public CroissantPrepareBakingProcess() {
        super(BakingStep.PREPARE);
    }

    @Override
    public Bread process(Recipe breadRecipe, List<Material> mainMaterial, List<Material> subMaterial) {

        List<MainMaterial> mainMaterials = mainMaterial.stream().map(it -> (MainMaterial) it).collect(Collectors.toList());
        verifyMatchingRecipeAndMainMaterialName(breadRecipe, mainMaterials);
        verifyMatchingRecipeAndMainMaterialRatio(breadRecipe, mainMaterials);

        return new Bread(getBreadName(), getStep());
    }

    private void verifyMatchingRecipeAndMainMaterialName(Recipe recipe, List<MainMaterial> mainMaterials) {
        Set<String> mainMaterialsNameInRecipe = recipe.getRecipeMainMaterials()
                                                      .stream()
                                                      .map(RecipeMainMaterial::getName)
                                                      .collect(Collectors.toSet());
        Set<String> mainMaterialsName = mainMaterials.stream()
                                                     .map(MainMaterial::getName)
                                                     .collect(Collectors.toSet());

        if (!mainMaterialsNameInRecipe.equals(mainMaterialsName)) {
            throw new IllegalArgumentException("The Main Materials are incorrect.");
        }

    }

    private void verifyMatchingRecipeAndMainMaterialRatio(Recipe recipe, List<MainMaterial> mainMaterials) {
        final int recipeMainMaterialAmountSum = recipe.getRecipeMainMaterials()
                                                      .stream()
                                                      .mapToInt(RecipeMainMaterial::getAmount)
                                                      .sum();

        final int mainMaterialAmountSum = mainMaterials.stream()
                                                       .mapToInt(MainMaterial::getAmount)
                                                       .sum();

        final double materialRatio = (double) mainMaterialAmountSum / recipeMainMaterialAmountSum;

        final Map<String, Integer> recipeMap = recipe.getRecipeMainMaterials().stream()
                                                     .collect(Collectors.toMap(RecipeMainMaterial::getName, RecipeMainMaterial::getAmount));

        boolean isEqualsMaterialRatio = mainMaterials.stream()
                                                     .allMatch(it -> ((double) it.getAmount() / recipeMap.get(it.getName())) == materialRatio);

        if (!isEqualsMaterialRatio) {
            throw new IllegalArgumentException("The ratio are incorrect.");
        }
    }
}
