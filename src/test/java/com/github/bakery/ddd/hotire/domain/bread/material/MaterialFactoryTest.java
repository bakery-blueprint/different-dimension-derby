package com.github.bakery.ddd.hotire.domain.bread.material;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;
import com.github.bakery.ddd.hotire.domain.bread.material.FlourMaterial.AlmondFlour;

class MaterialFactoryTest {

    @Test
    void getInstance() {
        // given
        final FlourMaterial flourMaterial = new AlmondFlour();
        final String json = flourMaterial.toJson();
        final MaterialFactory factory = new MaterialFactory();

        // when
        final Material material = factory.getInstance(BreadStatus.PREPARED, MaterialType.ALMOND, json);

        // then
        assertThat(material).isInstanceOf(AlmondFlour.class);
    }

}