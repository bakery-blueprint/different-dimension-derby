package com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Embeddable
public class RecipeMainMaterial {
    private String name;
    private int amount;

    public RecipeMainMaterial(final String name, final int amount) {
        this.name = name;
        this.amount = amount;
    }
}
