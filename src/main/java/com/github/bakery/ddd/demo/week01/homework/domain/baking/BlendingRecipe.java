package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class BlendingRecipe {

    public static final int MAX_MAIN_MATERIAL_COUNT = 2;

    private final long blendingRecipeId;
    private final List<RecipeMainMaterial> recipeMainMaterials;

    public BlendingRecipe(final Long blendingRecipeId, final List<RecipeMainMaterial> recipeMainMaterials) {

        if(MAX_MAIN_MATERIAL_COUNT > recipeMainMaterials.size()) {
            throw new IllegalStateException("The number of main material cannot exceed " + MAX_MAIN_MATERIAL_COUNT);
        }

        if(recipeMainMaterials.size() != new HashSet<>(recipeMainMaterials).size()) {
            throw new IllegalArgumentException("Duplicate materials");
        }
        this.blendingRecipeId = blendingRecipeId;
        this.recipeMainMaterials = Objects.requireNonNullElseGet(recipeMainMaterials, ArrayList::new);
    }

    @ToString
    @EqualsAndHashCode
    @Getter
    @RequiredArgsConstructor
    public static class RecipeMainMaterial {
        private final String name;
        private final int doughTime;
        private final int amount;
    }
}
