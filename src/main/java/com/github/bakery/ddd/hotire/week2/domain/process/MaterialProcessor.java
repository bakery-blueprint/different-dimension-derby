package com.github.bakery.ddd.hotire.week2.domain.process;

import java.util.List;

import com.github.bakery.ddd.hotire.week2.domain.material.Material;

public interface MaterialProcessor<T extends Material, R extends Material> {
    R make(List<T> material);
}
