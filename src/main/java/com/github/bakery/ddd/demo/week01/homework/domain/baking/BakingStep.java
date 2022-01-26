package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum BakingStep {
    PREPARE(0), DOUGH(1), FERMENT(2), BAKE(3), DECORATION(4), NONE(5);
    int order;

    BakingStep(final int order) {
        this.order = order;
    }

    public BakingStep getNextStep() {
        if (this.equals(BakingStep.NONE)) {
            return NONE;
        }

        return Arrays.stream(BakingStep.values())
            .filter(it -> it.getOrder() == this.getOrder() + 1)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 다음 단계호출 입니다."));
    }
}
