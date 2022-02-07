package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class Yeast extends Material {
    public Yeast(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.YEAST);
    }
}
