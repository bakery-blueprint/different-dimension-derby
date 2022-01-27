package com.github.bakery.ddd.hotire.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.bakery.ddd.hotire.domain.material.Butter;
import com.github.bakery.ddd.hotire.domain.material.Egg;
import com.github.bakery.ddd.hotire.domain.material.MacaronFilling;
import com.github.bakery.ddd.hotire.domain.material.Material;

public enum BreadType {
    CROISSANT,
    SOBORO,
    PIZZA,
    MACAROON {
        @Override
        List<Material> getRecipe() {
            return Stream.concat(super.getRecipe().stream(), Stream.of(new MacaronFilling(BreadStatus.DECORATE))).collect(Collectors.toList());
        }
    };
    List<Material> getRecipe() {
        return List.of(new Egg(BreadStatus.BAKE), new Butter(BreadStatus.BAKE));
    }
}
