package com.github.bakery.ddd.demo.week01.homework.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Temperature {
    private double value;
    private final String unit;

    public Temperature(double value, String unit) {
        this.value = value;
        if(!"C".equals(unit) || !"F".equals(unit)){
            throw new IllegalArgumentException("The temperature unit value can only be \"C\" or \"F\".");
        }
        this.unit = unit;
    }

    public void changeTemperature(int value){
        this.value = value;
    }
}
