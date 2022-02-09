package com.github.bakery.ddd.demo.week01.homework.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CreateBread {
    private final Long cafeId;
    private final String breadName;
    private final int amount;
}
