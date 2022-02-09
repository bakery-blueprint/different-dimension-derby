package com.github.bakery.ddd.demo.week01.homework.vo;

import lombok.Data;

@Data
public class BuyBread {
    private Long cafeId;
    private Long customerId;
    private String breadName;
    private int amount;
}
