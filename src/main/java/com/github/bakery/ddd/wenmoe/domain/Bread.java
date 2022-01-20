package com.github.bakery.ddd.wenmoe.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Bread {
    private String barcode;
    private BreadType breadType;
    private BreadState breadState;

    public Bread(BreadType breadType) {
        this.barcode = UUID.randomUUID().toString();
        this.breadType = breadType;
        this.breadState = BreadState.READY;
    }

    public void mature() {
        if (breadState != BreadState.DOUGH) {
            throw new IllegalStateException();
        }

        new Mature(LocalDate.now());    // Bread가 갖고있어야될까...?

        this.breadState = BreadState.MATURE;

    }

    public void makeDough(List<Flour> flours) {
        if (breadState != BreadState.READY) {
            throw new IllegalStateException();
        }

        new Dough(flours, new Water(new Random().nextInt(100)));    // Bread가 갖고있어야될까...?

        this.breadState = BreadState.DOUGH;
    }

    public void isCompleted(Mature mature) {
        // 일주일 경과하면 폐기처리
        if (ChronoUnit.DAYS.between(mature.getStartDate(), LocalDate.now()) > 7) {
            this.breadState = BreadState.DISPOSAL;
        }

        this.breadState = BreadState.COMPLETION;
    }
}
