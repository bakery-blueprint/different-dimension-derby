package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class MacaronFilling extends Material {
    public MacaronFilling(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.MACARON_FILLING);
    }
}
