package com.github.bakery.ddd.demo.week01.homework.domain;

import com.github.bakery.ddd.demo.week01.homework.domain.BlendingRecipe.MainMaterialAndRatio;
import com.github.bakery.ddd.demo.week01.homework.value.MainMaterialStep;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Baking {
    private Set<MainMaterial> mainMaterials = new HashSet<>();
    private BlendingRecipe recipe;

    public void setMainMaterialAndRecipe(final Set<MainMaterial> mainMaterials, final BlendingRecipe recipe){
        verifyMainMaterialsIsPrepare(mainMaterials);
        verifyRecipe(recipe);

        this.mainMaterials = mainMaterials;
        this.recipe = recipe;

        System.out.println("Materials to be blended is " + this.mainMaterials + ", The ratio of the main material is " + this.recipe.getMainMaterialAndRatios());
    }

    public void dough(final DoughWater doughWater){
        verifyUsingDoughWater(doughWater);
        verifyMainMaterialsIsPrepare(mainMaterials);
        verifyRecipe(this.recipe);

        mainMaterials = mainMaterials.stream()
            .map(it -> new MainMaterial(it.getName(), MainMaterialStep.DOUGH, it.getDoughTime()))
            .collect(Collectors.toSet());

        int totalDoughTime = mainMaterials.stream()
            .mapToInt(MainMaterial::getDoughTime)
            .sum();

        System.out.println("Total dough time is " + totalDoughTime + " minutes.");
    }

    private void verifyUsingDoughWater(DoughWater doughWater){
        if((doughWater.getTemperature().getValue() > 40.0f &&  "C".equals(doughWater.getTemperature().getUnit())
        || doughWater.getTemperature().getValue() > 104.0f &&  "F".equals(doughWater.getTemperature().getUnit()))) {
            throw new IllegalArgumentException("The temperature should be below 40C degrees.");
        }
    }
    private void verifyRecipe(final BlendingRecipe recipe) {

        if(recipe == null) {
            throw new IllegalArgumentException("Recipe is null!");
        }

        verifyMatchingRecipeAndMainMaterial(recipe);
        verifyDoughTime(recipe);
    }

    private void verifyDoughTime(BlendingRecipe recipe) {
        int sum = recipe.getMainMaterialAndRatios().stream()
            .map(MainMaterialAndRatio::getMainMaterial)
            .mapToInt(MainMaterial::getDoughTime)
            .sum();
        if(sum > 15) {
            throw new IllegalArgumentException("The total dough time should be no more than 15 minutes.");
        }
    }

    private void verifyMatchingRecipeAndMainMaterial(final BlendingRecipe recipe){
        Set<MainMaterial> mainMaterialsInRecipe = recipe.getMainMaterialAndRatios().stream()
            .map(MainMaterialAndRatio::getMainMaterial)
            .collect(Collectors.toSet());

        if(!mainMaterialsInRecipe.equals(mainMaterials)) {
            throw new IllegalArgumentException("This is not the correct recipe.");
        }
    }

    private void verifyMainMaterialsIsPrepare(final Set<MainMaterial> mainMaterials){
        boolean isBlendingPossible = mainMaterials.stream()
            .anyMatch(it -> it.getCurrentStep() != MainMaterialStep.PREPARE);
        if(isBlendingPossible) {
            throw new IllegalStateException("Not all main material are in the preparatory step.");
        }
    }
}
