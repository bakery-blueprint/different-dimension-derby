package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class Butter extends Material {
    public Butter(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.BUTTER);
    }
}
