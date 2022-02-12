package com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Temperature;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.MainMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.SubMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.CroissantRecipe;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.RecipeMainMaterial;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.RecipeSubMaterial;

class CroissantPrepareBakingProcessTest {

    @TestFactory
    Stream<DynamicTest> croissant_prepare_test() {
        List<Map<String, Object>> testCases = new ArrayList<>();

        testCases.add(
                Map.of(
                        "recipe", new CroissantRecipe(10, new Temperature(10, "C")
                                , 20, new Temperature(10, "C")
                                , List.of(new RecipeMainMaterial("밀가루", 10), new RecipeMainMaterial("쌀가루", 10))
                                , List.of(new RecipeSubMaterial("초콜릿"))),
                        "mainMaterials", List.of(new MainMaterial("밀가루", 10), new MainMaterial("쌀가루", 10)),
                        "subMaterial", List.of(new SubMaterial("초콜릿"))
                )
        );

        testCases.add(
                Map.of(
                        "recipe", new CroissantRecipe(10, new Temperature(10, "C")
                                , 20, new Temperature(10, "C")
                                , List.of(new RecipeMainMaterial("밀가루", 10), new RecipeMainMaterial("쌀가루", 10))
                                , List.of(new RecipeSubMaterial("초콜릿"))),
                        "mainMaterials", List.of(new MainMaterial("밀가루", 20), new MainMaterial("쌀가루", 20)),
                        "subMaterial", List.of(new SubMaterial("초콜릿"))
                )
        );

        BakingProcess bakingProcess = new CroissantPrepareBakingProcess();

        return testCases.stream()
                        .map(it -> dynamicTest(it.toString(),
                                               () -> {
                                                   Bread bread = bakingProcess.process((Recipe) it.get("recipe"), (List) it.get("mainMaterials"), (List) it.get("subMaterial"));
                                                   assertThat(bread.getBakingStep()).isEqualTo(BakingStep.PREPARE);
                                                   assertThat(bread.getName()).isEqualTo("Croissant");
                                               }
                        ));
    }

    @TestFactory
    Stream<DynamicTest> croissant_prepare_test_ratio_Exception() {
        List<Map<String, Object>> testCases = new ArrayList<>();

        testCases.add(
                Map.of(
                        "recipe", new CroissantRecipe(10, new Temperature(10, "C")
                                , 20, new Temperature(10, "C")
                                , List.of(new RecipeMainMaterial("밀가루", 10), new RecipeMainMaterial("쌀가루", 10))
                                , List.of(new RecipeSubMaterial("초콜릿"))),
                        "mainMaterials", List.of(new MainMaterial("밀가루", 30), new MainMaterial("쌀가루", 10)),
                        "subMaterial", List.of(new SubMaterial("초콜릿"))
                )
        );

        testCases.add(
                Map.of(
                        "recipe", new CroissantRecipe(10, new Temperature(10, "C")
                                , 20, new Temperature(10, "C")
                                , List.of(new RecipeMainMaterial("밀가루", 10), new RecipeMainMaterial("쌀가루", 10))
                                , List.of(new RecipeSubMaterial("초콜릿"))),
                        "mainMaterials", List.of(new MainMaterial("밀가루", 20), new MainMaterial("쌀가루", 40)),
                        "subMaterial", List.of(new SubMaterial("초콜릿"))
                )
        );

        BakingProcess bakingProcess = new CroissantPrepareBakingProcess();

        return testCases.stream().map(
                it -> dynamicTest(
                        it.toString(),
                        () -> Assertions.assertThrows(IllegalArgumentException.class, () -> bakingProcess.process((Recipe) it.get("recipe"), (List) it.get("mainMaterials"), (List) it.get("subMaterial")))
                ));
    }
}