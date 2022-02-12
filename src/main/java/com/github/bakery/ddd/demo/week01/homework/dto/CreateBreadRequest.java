package com.github.bakery.ddd.demo.week01.homework.dto;

import lombok.Data;

@Data
public class CreateBreadRequest {
    private Long cafeId;
    private String breadName;
    private int amount;
}
