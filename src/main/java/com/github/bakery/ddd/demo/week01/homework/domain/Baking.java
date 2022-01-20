package com.github.bakery.ddd.demo.week01.homework.domain;

import com.github.bakery.ddd.demo.week01.homework.domain.BlendingRecipe.RecipeMainMaterial;
import com.github.bakery.ddd.demo.week01.homework.value.MainMaterialStep;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Baking {
    public static int MAX_DOUGH_TIME  = 15;

    private long bakingId;
    private Set<MainMaterial> mainMaterials;
    private final BlendingRecipe recipe;

    public Baking(final Set<MainMaterial> mainMaterials, final BlendingRecipe recipe){
        verifySetMainMaterialAndRecipe(mainMaterials, recipe);
        this.mainMaterials = mainMaterials;
        this.recipe = recipe;
        System.out.println("Materials to be blended is " + this.mainMaterials + ", The ratio of the main material is " + this.recipe.getRecipeMainMaterials());
    }

    public void dough(final DoughWater doughWater){
        verifyUsingDoughWater(doughWater);

        mainMaterials = mainMaterials.stream()
            .map(it -> new MainMaterial(it.getName(), MainMaterialStep.DOUGH, it.getAmount()))
            .collect(Collectors.toSet());

        final int totalDoughTime = recipe.getRecipeMainMaterials().stream()
            .mapToInt(RecipeMainMaterial::getDoughTime)
            .sum();

        System.out.println("Total dough time is " + totalDoughTime + " minutes.");
    }

    private void verifyUsingDoughWater(final DoughWater doughWater){
        if((doughWater.getTemperature().getValue() > 40.0f &&  "C".equals(doughWater.getTemperature().getUnit())
            || doughWater.getTemperature().getValue() > 104.0f &&  "F".equals(doughWater.getTemperature().getUnit()))) {
            throw new IllegalArgumentException("The temperature should be below 40C degrees.");
        }
    }

    private void verifySetMainMaterialAndRecipe(final Set<MainMaterial> mainMaterials, final BlendingRecipe recipe) {
        verifyMainMaterialsIsPrepare(mainMaterials);
        if(recipe == null) {
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
        if(totalDoughTime > MAX_DOUGH_TIME) {
            throw new IllegalArgumentException("The total dough time should be no more than " + MAX_DOUGH_TIME + " minutes.");
        }
    }

    private void verifyMainMaterialsIsPrepare(final Set<MainMaterial> mainMaterials){
        final boolean isBlendingPossible = mainMaterials.stream()
            .anyMatch(it -> it.getCurrentStep() != MainMaterialStep.PREPARE);
        if(isBlendingPossible) {
            throw new IllegalStateException("Not all main material are in the preparatory step.");
        }
    }

    private void verifyMatchingRecipeAndMainMaterial(final BlendingRecipe recipe, final Set<MainMaterial> mainMaterials){

        final Set<String> mainMaterialNamesInRecipe = recipe.getRecipeMainMaterials().stream()
            .map(RecipeMainMaterial::getName)
            .collect(Collectors.toSet());

        Set<String> mainMaterialNames = mainMaterials.stream()
            .map(MainMaterial::getName)
            .collect(Collectors.toSet());

        if(!mainMaterialNamesInRecipe.equals(mainMaterialNames)) {
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
