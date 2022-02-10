package com.github.bakery.ddd.yun0.bread.infrastructure.processor;

import com.github.bakery.ddd.yun0.bread.infrastructure.recipe.BaseRecipe;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BakeryProcessor {
    private final BaseRecipe baseRecipe;

//    public PreparedIngredients prepare(Set<Ingredient> ingredients) {
//        verifyPreparing(ingredients);
//        return new PreparedIngredients(ingredients);
//    }
//
//    protected void verifyPreparing(Set<Ingredient> ingredients) {
//        if (ingredients.size() > baseRecipe.getMaxFlourTypeCount()) {
//            throw new IllegalArgumentException("재료 종류가 너무 많아요!");
//        }
//        if (ingredients.stream().map(Ingredient::getAmount)
//                .reduce((a, b) -> a / (a + b))
//                .filter(ratio -> ratio < baseRecipe.getGoldenRatio())
//                .isEmpty()) {
//            throw new IllegalArgumentException("비율이 이상해요!");
//        }
//    }
//
//    public Dough knead(PreparedIngredients preparedIngredients, int temperature, int minutes) {
//        verifyKneading(temperature, minutes);
//        return new Dough(preparedIngredients);
//    }
//
//    protected void verifyKneading(int temperature, int minutes) {
//        if (temperature > baseRecipe.getMaxKneadingTemperature()) {
//            throw new IllegalArgumentException("반죽이 푹 익어버렸어요!");
//        }
//        if (minutes > baseRecipe.getMaxKneadingMinutes()) {
//            throw new IllegalArgumentException("반죽이 너무 단단해졌어요!");
//        }
//    }
//
//    public RipenedDough ripen(Dough dough, int temperature, int minutes) {
//        verifyRipening(temperature, minutes);
//        return new RipenedDough(dough);
//    }
//
//    protected void verifyRipening(int temperature, int minutes) {
//        if (temperature > baseRecipe.getMaxRipeningTemperature()) {
//            throw new IllegalArgumentException("반죽이 익어버렸어요!");
//        }
//        if (minutes > baseRecipe.getMaxRipeningMinutes()) {
//            throw new IllegalArgumentException("반죽이 상해버렸어요!");
//        }
//    }
//
//    public Bread bake(RipenedDough ripenedDough, ProductType productType, int temperature, int minutes) {
//        verifyBaking(temperature, minutes);
//        return new Bread(ripenedDough, productType, new Recipe(0.5, 2, 40, 15, 40, 15, 40, 15));
//    }
//
//    protected void verifyBaking(int temperature, int minutes) {
//        if (temperature > baseRecipe.getMaxBakingTemperature()) {
//            throw new IllegalArgumentException("빵이 뜨거워서 타버렸어요!");
//        }
//        if (minutes > baseRecipe.getMaxBakingMinutes()) {
//            throw new IllegalArgumentException("빵이 오래 구워서 타버렸어요!");
//        }
//    }
//
//    public DecoratedBread decorate(Bread bread, DecoratingPreparedIngredients decoratingIngredients) {
//        verifyDecorating(bread, decoratingIngredients);
//        return new DecoratedBread(bread);
//    }
//
//    protected void verifyDecorating(Bread bread, DecoratingPreparedIngredients decoratingIngredients) {
//        if (!bread.getType().canDecorateWith(decoratingIngredients)) {
//            throw new IllegalArgumentException("재료가 빵에 어울리지 않아요!");
//        }
//    }
}
