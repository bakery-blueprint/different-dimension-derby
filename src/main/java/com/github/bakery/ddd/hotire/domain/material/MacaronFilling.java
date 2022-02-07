package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class MacaronFilling extends Material {
    public MacaronFilling(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.MACARON_FILLING);
    }
}
