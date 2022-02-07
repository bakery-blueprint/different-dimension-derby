package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class Egg extends Material{
    public Egg(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.AGG);
    }
}
