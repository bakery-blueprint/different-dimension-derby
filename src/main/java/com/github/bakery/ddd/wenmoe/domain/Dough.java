package com.github.bakery.ddd.wenmoe.domain;

import org.springframework.util.CollectionUtils;

import java.util.List;

public class Dough {
    private int minute; // 반죽 시간..?
    private List<Flour> flours;
    private Water water;

    public Dough(List<Flour> flours, Water water) {
        if (CollectionUtils.isEmpty(flours) || flours.size() > 2) {
            throw new IllegalStateException();
        }

        if (water.getTemperature() > 40) {
            throw new IllegalStateException("Water too hot!");
        }

        this.flours = flours;
        this.water = water;
        this.minute = 0;
    }
}
