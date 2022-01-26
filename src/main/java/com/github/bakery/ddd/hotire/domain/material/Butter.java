package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class Butter extends Material {
    public Butter(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.BUTTER);
    }
}
