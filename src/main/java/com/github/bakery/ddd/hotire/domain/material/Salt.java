package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class Salt extends Material {
    public Salt(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.SALT);
    }
}
