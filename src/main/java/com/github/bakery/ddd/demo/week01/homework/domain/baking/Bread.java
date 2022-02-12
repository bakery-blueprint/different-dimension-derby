package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@Getter
public class Bread {

    private String name;
    private Integer price;

    @Embedded
    private BakingStep bakingStep;

    public Bread(final String name, final BakingStep bakingStep) {
        this.name = name;
        this.bakingStep = bakingStep;
    }

    public BakingStep getCurrentBakingStep() {
        return bakingStep;
    }

}
