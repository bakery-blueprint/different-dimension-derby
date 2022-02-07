package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class PizzaToping extends Material {
    public PizzaToping(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.PIZZA_TOPPING);
    }
}
