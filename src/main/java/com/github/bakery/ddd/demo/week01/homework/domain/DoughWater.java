package com.github.bakery.ddd.demo.week01.homework.domain;

import com.github.bakery.ddd.demo.week01.homework.value.Temperature;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DoughWater {
    private final Temperature temperature;
}
