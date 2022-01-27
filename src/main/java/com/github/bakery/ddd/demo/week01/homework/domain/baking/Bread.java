package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import javax.persistence.Access;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import org.springframework.data.annotation.AccessType.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
@Getter
public class Bread {

    private String name;

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
