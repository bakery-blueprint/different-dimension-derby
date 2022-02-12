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
public class RecipeSubMaterial {
    private String name;

    public RecipeSubMaterial(final String name) {
        this.name = name;
    }
}
