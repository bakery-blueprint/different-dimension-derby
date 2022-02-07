package com.github.bakery.ddd.hotire.domain;

import com.github.bakery.ddd.hotire.domain.material.MaterialType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Recipe {
    private final MaterialType materialType;
    private final Long mass;
}
