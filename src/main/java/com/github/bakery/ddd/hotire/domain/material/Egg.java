package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class Egg extends Material{
    public Egg(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.AGG);
    }
}
