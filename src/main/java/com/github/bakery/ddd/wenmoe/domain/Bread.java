package com.github.bakery.ddd.wenmoe.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class Bread {
    @Id
    @Column(name = "barcode")
    private String id;

    @Column(name = "bread_type")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private BreadState breadState;

    public Bread(BreadType breadType) {
        this.id = UUID.randomUUID().toString();
        this.breadType = breadType;
        this.breadState = BreadState.READY;
    }

    public void changeBreadState(BreadState breadState) {
        this.breadState = breadState;
    }

}
