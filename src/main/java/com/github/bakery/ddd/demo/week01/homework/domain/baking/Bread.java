package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import java.time.OffsetDateTime;

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
    private int price;
    private OffsetDateTime expirationDate;

    @Embedded
    private BakingStep bakingStep;

    public Bread(final String name, final BakingStep bakingStep) {
        this.name = name;
        this.bakingStep = bakingStep;
    }

    public Bread(final String name, final BakingStep bakingStep, final OffsetDateTime expirationDate) {
        this.name = name;
        this.bakingStep = bakingStep;
        this.expirationDate = expirationDate;
    }

    public BakingStep getCurrentBakingStep() {
        return bakingStep;
    }

}
