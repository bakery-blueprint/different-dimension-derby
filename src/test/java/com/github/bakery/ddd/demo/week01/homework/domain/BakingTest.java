package com.github.bakery.ddd.demo.week01.homework.domain;


import com.github.bakery.ddd.demo.week01.homework.domain.material.MainMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.recipe.BlendingRecipe;
import com.github.bakery.ddd.demo.week01.homework.domain.recipe.BlendingRecipe.RecipeMainMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Baking;
import com.github.bakery.ddd.demo.week01.homework.value.MainMaterialStep;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class BakingTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestMakeBaking() {

        return Stream.of(
            Map.of(
                "MainMaterialSet", Set.of(new MainMaterial("밀가루", MainMaterialStep.PREPARE,  150), new MainMaterial("아몬드 가루", MainMaterialStep.PREPARE,  75)),
                "BlendingRecipe", new BlendingRecipe(1L, List.of(new RecipeMainMaterial("밀가루", 5, 300), new RecipeMainMaterial("아몬드 가루", 3, 150)))
            ),Map.of(
                "MainMaterialSet", Set.of(new MainMaterial("밀가루", MainMaterialStep.PREPARE,  60), new MainMaterial("쌀가루", MainMaterialStep.PREPARE,  60)),
                "BlendingRecipe", new BlendingRecipe(1L, List.of(new RecipeMainMaterial("밀가루", 7, 300), new RecipeMainMaterial("쌀가루",7, 300)))
            ),Map.of(
                "MainMaterialSet", Set.of(new MainMaterial("쌀가루", MainMaterialStep.PREPARE,  400), new MainMaterial("아몬드 가루", MainMaterialStep.PREPARE,  200)),
                "BlendingRecipe", new BlendingRecipe(1L, List.of(new RecipeMainMaterial("쌀가루", 5, 100), new RecipeMainMaterial("아몬드 가루", 3, 50))))
        ).map(testCase ->
            DynamicTest.dynamicTest("create baking test : " + testCase, () -> new Baking((Set<MainMaterial>) testCase.get("MainMaterialSet"), (BlendingRecipe) testCase.get("BlendingRecipe")))
        );
    }
}