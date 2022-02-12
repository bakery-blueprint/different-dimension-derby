package com.github.bakery.ddd.demo.week01.homework.domain.baking.material;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Temperature;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DoughWater extends SubMaterial {

    private final String name = "반죽물";
    private final Temperature temperature;

    public DoughWater(final String name, final Temperature temperature) {
        super(name);
        this.temperature = temperature;
    }
}
