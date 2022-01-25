package com.github.bakery.ddd.hotire.week2.domain.process;

import java.util.List;

import com.github.bakery.ddd.hotire.week2.domain.material.Dough;
import com.github.bakery.ddd.hotire.week2.domain.material.DoughMaterial;

public class DoughMaterialProcessor implements MaterialProcessor<DoughMaterial, Dough> {

    @Override
    public Dough make(List<DoughMaterial> material) {
        return null;
    }
}
