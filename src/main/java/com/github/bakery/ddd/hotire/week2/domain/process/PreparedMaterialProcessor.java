package com.github.bakery.ddd.hotire.week2.domain.process;

import java.util.List;

import com.github.bakery.ddd.hotire.week2.domain.material.Flour;
import com.github.bakery.ddd.hotire.week2.domain.material.FlourMaterial;

public class PreparedMaterialProcessor implements MaterialProcessor<FlourMaterial, Flour> {

    @Override
    public Flour make(List<FlourMaterial> material) {
        return new Flour(material);
    }
}
