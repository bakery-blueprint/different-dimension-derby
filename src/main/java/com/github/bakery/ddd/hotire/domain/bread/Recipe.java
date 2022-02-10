package com.github.bakery.ddd.hotire.domain.bread;

import com.github.bakery.ddd.hotire.domain.bread.material.MaterialType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Recipe {
    private final MaterialType materialType;
    private final Long mass;
}
