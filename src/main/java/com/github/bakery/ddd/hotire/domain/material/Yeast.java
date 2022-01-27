package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class Yeast extends Material {
    public Yeast(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.YEAST);
    }
}
