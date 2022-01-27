package com.github.bakery.ddd.wenmoe.domain;

import lombok.Data;

public interface SubIngredient {

    @Data
    class PizzaTopping implements SubIngredient {

    }

    @Data
    class SoboroTopping implements SubIngredient {

    }

    @Data
    class MacaronFilling implements SubIngredient {

    }
}
