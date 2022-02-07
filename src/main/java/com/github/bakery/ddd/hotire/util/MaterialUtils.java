package com.github.bakery.ddd.hotire.util;

import java.util.List;
import java.util.stream.Collectors;

import com.github.bakery.ddd.hotire.domain.bread.material.Material;

public abstract class MaterialUtils {

    public static <T extends Material> T findMaterial(List<? extends Material> material, Class<T> type) {
        final List<T> flours = material.stream()
                                       .filter(type::isInstance)
                                       .map(type::cast)
                                       .collect(Collectors.toList());

        if (flours.size() != 1) {
            throw new IllegalArgumentException("invalid material size");
        }

        return flours.get(0);
    }
}
