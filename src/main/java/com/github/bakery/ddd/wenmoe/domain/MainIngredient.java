package com.github.bakery.ddd.wenmoe.domain;

import lombok.Data;

public interface MainIngredient {

    @Data
    class Flour implements MainIngredient {

    }

    @Data
    class Water implements MainIngredient {
        private int temperature;

        public Water(int temperature) {
            if (temperature > 40) {
                throw new IllegalStateException("Water too hot!");
            }
        }
    }

    @Data
    class Salt implements MainIngredient {

    }

    @Data
    class Butter implements MainIngredient {

    }

    @Data
    class Egg implements MainIngredient {

    }
}
