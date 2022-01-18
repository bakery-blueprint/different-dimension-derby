package com.github.bakery.ddd.hotire.week2.domain.material;

import java.util.Set;

import org.springframework.util.CollectionUtils;

public class Flour implements Material {
    private final Set<FlourMaterial> flourMaterials;

    public Flour(Set<FlourMaterial> flourMaterials) {
        this.flourMaterials = verifyFlourMaterial(flourMaterials);
    }

    private Set<FlourMaterial> verifyFlourMaterial(Set<FlourMaterial> flourMaterials) {
        if (CollectionUtils.isEmpty(flourMaterials) || flourMaterials.size() > 2) {
            throw new IllegalArgumentException("invalid flour material size");
        }
        return flourMaterials;
    }
}
