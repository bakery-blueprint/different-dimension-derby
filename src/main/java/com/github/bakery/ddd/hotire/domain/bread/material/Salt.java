package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class Salt extends Material {
    public Salt(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.SALT);
    }
}
