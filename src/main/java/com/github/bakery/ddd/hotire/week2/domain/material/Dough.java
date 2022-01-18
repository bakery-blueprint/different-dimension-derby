package com.github.bakery.ddd.hotire.week2.domain.material;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

import org.springframework.util.CollectionUtils;

/**
 * Material Root
 */
public class Dough implements Material {
    private final Flour flour;
    private final Water water;
    private final Duration duration;
    private final Instant createdDate;

    public Dough(Flour flour, Water water, Duration duration) {
        this.flour = flour;
        this.water = verifyWaterTemperature(water);
        this.duration = duration;
        this.createdDate = Instant.now();
    }

    private Set<FlourMaterial> verifyFlourMaterial(Set<FlourMaterial> flourMaterials) {
        if (CollectionUtils.isEmpty(flourMaterials) || flourMaterials.size() > 2) {
            throw new IllegalArgumentException("invalid flour material size");
        }
        return flourMaterials;
    }

    private Water verifyWaterTemperature(Water water) {
        if (water.getTemperature() < 45) {
            throw new IllegalArgumentException("invalid water temperature");
        }
        return water;
    }
}
