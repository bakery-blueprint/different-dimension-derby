package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

import lombok.Getter;

@Getter
public class Water extends Material {
    private final Double temperature;

    public Water(BreadStatus breadStatus, Double temperature) {
        super(breadStatus, MaterialType.WATER);
        this.temperature = temperature;
    }
}
