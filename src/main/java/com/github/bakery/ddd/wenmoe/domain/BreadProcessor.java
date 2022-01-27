package com.github.bakery.ddd.wenmoe.domain;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@RequiredArgsConstructor
public class BreadProcessor {
    private final Bread bread;

    public Dough makeDough(Set<MainIngredient> mainIngredients) {
        if (bread.getBreadState() != BreadState.READY) {
            throw new IllegalStateException();
        }

        bread.changeBreadState(BreadState.DOUGH);

        return new Dough(mainIngredients);
    }

    public Mature mature(int temperature) {
        if (bread.getBreadState() != BreadState.DOUGH) {
            throw new IllegalStateException();
        }

        if (temperature != bread.getBreadType().getMatureTemperature()) {
            throw new IllegalArgumentException("숙성 온도가 맞지 않습니다.");
        }

        bread.changeBreadState(BreadState.MATURE);

        return new Mature(LocalDate.now(), temperature);
    }

    public Oven goToOven(Mature mature, Set<SubIngredient> subIngredients, int temperature) {
        if (ChronoUnit.DAYS.between(mature.getStartDate(), LocalDate.now()) > bread.getBreadType().getMatureDays()) {
            throw new IllegalArgumentException("최대 숙성기간을 지났습니다.");
        }

        if (bread.getBreadState() != BreadState.MATURE) {
            throw new IllegalStateException();
        }

        if (temperature != bread.getBreadType().getOvenTemperature()) {
            throw new IllegalArgumentException("오븐 온도가 맞지 않습니다.");
        }

        bread.changeBreadState(BreadState.OVEN);

        return new Oven(LocalDateTime.now(), temperature, subIngredients);
    }

    public Decoration decorate(Oven oven, Set<SubIngredient> subIngredients) {
        if (ChronoUnit.MINUTES.between(oven.getStartDateTime(), LocalDateTime.now()) > bread.getBreadType().getOvenMinutes()) {
            throw new IllegalArgumentException("타버렸어요...!");
        }

        if (bread.getBreadState() != BreadState.OVEN) {
            throw new IllegalStateException();
        }

        bread.changeBreadState(BreadState.DECORATION);

        return new Decoration(subIngredients);
    }
}
