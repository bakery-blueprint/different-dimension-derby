package com.github.bakery.ddd.hotire.week2.domain.material;

import java.util.List;
import java.util.stream.Collectors;

/**
 * FermentedMaterial Root
 */
public class FermentedDough implements Material {
    private final Dough dough;
    private final Yeast yeast;

    public FermentedDough(List<FermentedMaterial> fermentedMaterials) {
        this.dough = findDoughMaterial(fermentedMaterials, Dough.class);
        this.yeast = findDoughMaterial(fermentedMaterials, Yeast.class);
    }

    private <T extends FermentedMaterial> T findDoughMaterial(List<FermentedMaterial> material, Class<T> type) {
        final List<T> flours = material.stream()
                                       .filter(type::isInstance)
                                       .map(type::cast)
                                       .collect(Collectors.toList());

        if (flours.size() != 1) {
            throw new IllegalArgumentException("invalid Fermented material size");
        }

        return flours.get(0);
    }
}
