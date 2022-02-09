package com.github.bakery.ddd.demo.week01.homework.dto;

import lombok.Data;

@Data
public class CreateBreadResponse {
    private String breadName;
    private int amount;
}
