package com.github.bakery.ddd.demo.week01.homework.domain.baking.material;

import javax.persistence.DiscriminatorValue;

import lombok.Getter;

@Getter
@DiscriminatorValue("SUB")
public class SubMaterial extends Material {
    private final String name;

    public SubMaterial(String name) {
        super();
        this.name = name;
    }
}
