package com.github.bakery.ddd.demo.week01.homework.domain.cafe;

import java.util.List;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;

import lombok.Getter;

@Getter
public class Bag {

    private final List<Bread> breads;
    private final int change;

    public Bag(List<Bread> breads, int change) {
        this.breads = breads;
        this.change = change;
    }
}
