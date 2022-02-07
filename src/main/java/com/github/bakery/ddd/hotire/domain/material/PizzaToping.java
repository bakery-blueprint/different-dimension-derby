package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class PizzaToping extends Material {
    public PizzaToping(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.PIZZA_TOPPING);
    }
}
