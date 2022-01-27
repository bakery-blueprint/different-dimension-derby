package com.github.bakery.ddd.wenmoe.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Bread {
    private String barcode;
    private BreadType breadType;
    private BreadState breadState;

    public Bread(BreadType breadType) {
        this.barcode = UUID.randomUUID().toString();
        this.breadType = breadType;
        this.breadState = BreadState.READY;
    }

    public void changeBreadState(BreadState breadState) {
        this.breadState = breadState;
    }
}
