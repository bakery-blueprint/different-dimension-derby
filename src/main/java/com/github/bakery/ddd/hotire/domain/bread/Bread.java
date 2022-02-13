package com.github.bakery.ddd.hotire.domain.bread;

import java.time.Instant;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.github.bakery.ddd.hotire.domain.bread.material.Material;
import com.github.bakery.ddd.hotire.domain.bread.material.Water;
import com.github.bakery.ddd.hotire.domain.bread.material.Yeast;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Root
 */
@Getter
@RequiredArgsConstructor
public class Bread {
    private final Long id;
    private final BreadType breadType;
    private final Instant createdDate;
    private BreadStatus breadStatus;
    private List<Material> materials;
    private Instant modifiedDate;
    private Instant expirationDate;

    public void doPrepared(List<Material> materials) {
        verifyStatus(BreadStatus.PREPARED);
        this.materials.addAll(verifyFlourMaterial(materials));
        this.breadStatus = BreadStatus.PREPARED;
        this.modifiedDate = Instant.now();
    }

    public void doDough(Water water) {
        verifyStatus(BreadStatus.DOUGH);
        this.materials.add(verifyWaterTemperature(water));
        this.breadStatus = BreadStatus.DOUGH;
        this.modifiedDate = Instant.now();
    }

    public void doFermented(Yeast yeast) {
        verifyStatus(BreadStatus.FERMENTED);
        this.materials.add(yeast);
        this.breadStatus = BreadStatus.FERMENTED;
        this.modifiedDate = Instant.now();
    }

    public void doBake(List<Material> materials) {
        verifyStatus(BreadStatus.BAKE);
        verifyRecipe(materials);
        this.breadStatus = BreadStatus.BAKE;
        this.modifiedDate = Instant.now();
    }

    public void doDecorate(List<Material> materials) {
        verifyStatus(BreadStatus.DECORATE);
        verifyRecipe(materials);
        this.breadStatus = BreadStatus.DECORATE;
        this.modifiedDate = Instant.now();
    }

    private void verifyRecipe(List<Material> materials) {
        breadType.getRecipe().stream()
                 .filter(it -> it.getBreadStatus() == breadStatus)
                 .forEach(it -> materials.stream()
                                         .filter(m -> m.getMaterialType() == it.getMaterialType())
                                         .findFirst()
                                         .filter(m -> !m.equalsContext(it))
                                         .orElseThrow());
    }

    private BreadStatus verifyStatus(BreadStatus next) {
        if (breadStatus.getOrder() != next.getOrder() - 1) {
            throw new IllegalArgumentException("invalid status");
        }
        return next;
    }

    private List<Material> verifyFlourMaterial(List<Material> flourMaterials) {
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
