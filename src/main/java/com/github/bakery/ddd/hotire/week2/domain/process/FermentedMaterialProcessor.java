package com.github.bakery.ddd.hotire.week2.domain.process;

import java.util.List;

import com.github.bakery.ddd.hotire.week2.domain.material.FermentedDough;
import com.github.bakery.ddd.hotire.week2.domain.material.FermentedMaterial;

public class FermentedMaterialProcessor implements MaterialProcessor<FermentedMaterial, FermentedDough>{
    @Override
    public FermentedDough make(List<FermentedMaterial> material) {
        return null;
    }
}
