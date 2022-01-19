package com.github.bakery.ddd.hotire.week2.domain.material;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

/**
 * DoughMaterial Root
 */
@Getter
public class Dough implements FermentedMaterial {
    private final Flour flour;
    private final Water water;
    private final Instant createdDate;

    public Dough(List<DoughMaterial> materials) {
        this.flour = findDoughMaterial(materials, Flour.class);
        this.water = verifyWaterTemperature(findDoughMaterial(materials, Water.class));
        this.createdDate = Instant.now();
    }

    private <T extends DoughMaterial> T findDoughMaterial(List<DoughMaterial> material, Class<T> type) {
        final List<T> flours = material.stream()
                                       .filter(type::isInstance)
                                       .map(type::cast)
                                       .collect(Collectors.toList());

        if (flours.size() != 1) {
            throw new IllegalArgumentException("invalid dough material size");
        }

        return flours.get(0);
    }

    private Water verifyWaterTemperature(Water water) {
        if (water.getTemperature() < 45) {
            throw new IllegalArgumentException("invalid water temperature");
        }
        return water;
    }
}
