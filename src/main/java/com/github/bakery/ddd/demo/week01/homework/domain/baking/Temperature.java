package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Embeddable
public class Temperature {

    @Column(name = "temperature")
    private double value;
    private String unit;

    public Temperature(double value, String unit) {
        this.value = value;
        if (!"C".equals(unit) && !"F".equals(unit)) {
            throw new IllegalArgumentException("The temperature unit value can only be \"C\" or \"F\".");
        }
        this.unit = unit;
    }

    public void changeTemperature(int value) {
        this.value = value;
    }
}
