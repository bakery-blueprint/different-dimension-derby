package com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.croissant;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
abstract public class CroissantBakingProcess implements BakingProcess {

    private final String breadName = "Croissant";

    private final BakingStep step;

    public CroissantBakingProcess(BakingStep step) {
        this.step = step;
    }
}
