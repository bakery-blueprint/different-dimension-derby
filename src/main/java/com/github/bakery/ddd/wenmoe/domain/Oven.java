package com.github.bakery.ddd.wenmoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Oven {
    private LocalDateTime startDateTime;
    private int temperature;
    private Set<SubIngredient> subIngredients;
}
