package com.github.bakery.ddd.demo.week01.homework.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import com.github.bakery.ddd.demo.week01.homework.domain.BlendingRecipe.RecipeMainMaterial;
import com.github.bakery.ddd.demo.week01.homework.value.MainMaterialStep;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
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
            DynamicTest.dynamicTest("create baking test : " + testCase, () -> assertNotNull( new Baking((Set) testCase.get("MainMaterialSet"), (BlendingRecipe) testCase.get("BlendingRecipe"))))
        );
    }
}