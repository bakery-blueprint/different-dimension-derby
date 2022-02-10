package com.github.bakery.ddd.hotire.domain.bread.material;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

public class SoboroHead extends Material {
    public SoboroHead(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.SOBORO_HEAD);
    }
}
