package com.github.bakery.ddd.demo.week01.homework.domain.baking.material;

import javax.persistence.DiscriminatorValue;

import lombok.Getter;

@Getter
@DiscriminatorValue("MAIN")
public class MainMaterial extends Material {
    private final String name;
    private final int amount;

    public MainMaterial(String name, int amount) {
        super();
        this.name = name;
        this.amount = amount;
    }

}
