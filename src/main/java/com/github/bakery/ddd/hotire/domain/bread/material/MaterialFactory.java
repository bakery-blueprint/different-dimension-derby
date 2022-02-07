package com.github.bakery.ddd.hotire.domain.bread.material;

import java.util.Map;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;
import com.github.bakery.ddd.hotire.domain.bread.material.FlourMaterial.AlmondFlour;
import com.github.bakery.ddd.hotire.domain.bread.material.FlourMaterial.RiceFlour;
import com.github.bakery.ddd.hotire.util.JsonUtils;

public class MaterialFactory {
    private final Map<BreadStatus, Map<MaterialType, Class<? extends Material>>> mapper = Map.of(
            BreadStatus.PREPARED, Map.of(MaterialType.RICE, RiceFlour.class, MaterialType.ALMOND, AlmondFlour.class),
            BreadStatus.DOUGH, Map.of(MaterialType.WATER, Water.class),
            BreadStatus.FERMENTED, Map.of(MaterialType.YEAST, Yeast.class)
    );

    @SuppressWarnings("unchecked")
    public <T extends Material> T getInstance(BreadStatus breadStatus, MaterialType materialType, String json) {
        return (T) JsonUtils.cast(json, mapper.get(breadStatus).get(materialType));
    }
}
