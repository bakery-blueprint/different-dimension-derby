package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BlendingRecipe.RecipeMainMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.Material;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Baking {

    public static int MAX_DOUGH_TIME = 15;

    private long bakingId;
    private final Recipe breadRecipe;
    private Bread bread;

    public Baking(final Recipe breadRecipe, List<Material> mainMaterial, List<Material> subMaterial) {
        this.breadRecipe = breadRecipe;
        BakingProcess process = breadRecipe.getProcess(BakingStep.PREPARE);
        this.bread = process.process(this.breadRecipe, mainMaterial, subMaterial);
    }

    public void processNextStep(List<Material> mainMaterial, List<Material> subMaterial) {
        BakingProcess process = breadRecipe.getProcess(bread.getCurrentBakingStep().getNextStep());
        this.bread = process.process(this.breadRecipe, mainMaterial, subMaterial);
    }

    public void dough(final DoughWater doughWater) {
        verifyUsingDoughWater(doughWater);
    }

    private void verifyUsingDoughWater(final DoughWater doughWater) {
        if ((doughWater.getTemperature().getValue() > 40.0f && "C".equals(doughWater.getTemperature().getUnit())
            || doughWater.getTemperature().getValue() > 104.0f && "F".equals(doughWater.getTemperature().getUnit()))) {
            throw new IllegalArgumentException("The temperature should be below 40C degrees.");
        }
    }

    private void verifySetMainMaterialAndRecipe(final Set<MainMaterial> mainMaterials, final BlendingRecipe recipe) {
        verifyMainMaterialsIsPrepare(mainMaterials);
        if (recipe == null) {
            throw new IllegalArgumentException("Recipe is null!");
        }
        verifyTotalDoughTimeMaximum(recipe);
        verifyMatchingRecipeAndMainMaterial(recipe, mainMaterials);
        verifyMatchingRecipeAndMainMaterialRatio(recipe, mainMaterials);
    }

    private void verifyTotalDoughTimeMaximum(final BlendingRecipe recipe) {
        final int totalDoughTime = recipe.getRecipeMainMaterials().stream()
            .mapToInt(RecipeMainMaterial::getDoughTime)
            .sum();
        if (totalDoughTime > MAX_DOUGH_TIME) {
            throw new IllegalArgumentException("The total dough time should be no more than " + MAX_DOUGH_TIME + " minutes.");
        }
    }

    private void verifyMainMaterialsIsPrepare(final Set<MainMaterial> mainMaterials) {
        final boolean isBlendingPossible = mainMaterials.stream()
            .anyMatch(it -> it.getCurrentStep() != MainMaterialStep.PREPARE);
        if (isBlendingPossible) {
            throw new IllegalStateException("Not all main material are in the preparatory step.");
        }
    }

    private void verifyMatchingRecipeAndMainMaterial(final BlendingRecipe recipe, final Set<MainMaterial> mainMaterials) {

        final Set<String> mainMaterialNamesInRecipe = recipe.getRecipeMainMaterials().stream()
            .map(RecipeMainMaterial::getName)
            .collect(Collectors.toSet());

        Set<String> mainMaterialNames = mainMaterials.stream()
            .map(MainMaterial::getName)
            .collect(Collectors.toSet());

        if (!mainMaterialNamesInRecipe.equals(mainMaterialNames)) {
            throw new IllegalArgumentException("This is not the correct recipe.");
        }
    }

    private void verifyMatchingRecipeAndMainMaterialRatio(BlendingRecipe recipe, Set<MainMaterial> mainMaterials) {
        final int recipeMainMaterialAmountSum = new HashSet<>(recipe.getRecipeMainMaterials()).stream()
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
