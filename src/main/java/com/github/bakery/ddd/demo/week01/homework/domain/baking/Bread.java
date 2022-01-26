package com.github.bakery.ddd.demo.week01.homework.domain.baking;

public class Bread {

    private final String name;
    private final BakingStep bakingStep;

    public Bread(final String name, final BakingStep bakingStep) {
        this.name = name;
        this.bakingStep = bakingStep;
    }

    public BakingStep getCurrentBakingStep() {
        return bakingStep;
    }

}
