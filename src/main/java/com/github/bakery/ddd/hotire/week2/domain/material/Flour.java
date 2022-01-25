package com.github.bakery.ddd.hotire.week2.domain.material;

import java.time.Duration;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * FlourMaterial Root
 */
@Getter
@EqualsAndHashCode
public class Flour implements DoughMaterial {
    private final List<FlourMaterial> flourMaterials;

    private final Duration duration;

    public Flour(List<FlourMaterial> flourMaterials) {
        this.flourMaterials = verifyFlourMaterial(flourMaterials);
        this.duration = resolveDuration(flourMaterials);
    }

    private List<FlourMaterial> verifyFlourMaterial(List<FlourMaterial> flourMaterials) {
        if (CollectionUtils.isEmpty(flourMaterials) || flourMaterials.size() > 2) {
            throw new IllegalArgumentException("invalid flour material size");
        }
        return flourMaterials;
    }

    private Duration resolveDuration(List<FlourMaterial> flourMaterials) {
        return Duration.ofSeconds(flourMaterials.stream().map(FlourMaterial::getDuration).mapToLong(Duration::getSeconds).sum());
    }

}
