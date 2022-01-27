package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;

public class SoboroHead extends Material {
    public SoboroHead(BreadStatus breadStatus) {
        super(breadStatus, MaterialType.SOBORO_HEAD);
    }
}
