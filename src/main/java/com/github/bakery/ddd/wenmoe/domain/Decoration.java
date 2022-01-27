package com.github.bakery.ddd.wenmoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class Decoration {
    private Set<SubIngredient> subIngredients;
}
