package com.github.bakery.ddd.yun0.week01.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Dough {
    private final Ingredients ingredients;

    @Override
    public String toString() {
        return ingredients + "로 만든 생반죽😝";
    }
}
