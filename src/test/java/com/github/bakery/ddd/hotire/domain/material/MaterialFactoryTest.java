package com.github.bakery.ddd.hotire.domain.material;

import org.junit.jupiter.api.Test;

import com.github.bakery.ddd.hotire.domain.BreadStatus;
import com.github.bakery.ddd.hotire.domain.material.FlourMaterial.AlmondFlour;

class MaterialFactoryTest {

    @Test
    void getInstance() {
        final FlourMaterial flourMaterial = new AlmondFlour();
        final String json = flourMaterial.toJson();

        final MaterialFactory factory = new MaterialFactory();

        final Material material = factory.getInstance(BreadStatus.PREPARED, MaterialType.ALMOND, json);

    }

}