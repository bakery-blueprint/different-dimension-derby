package com.github.bakery.ddd.wenmoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BreadType { // 빵을 완성하기 위한 속성을 정의하여 레시피처럼 사용
    SOBORO(-30, 7, 200, 120),
    CROISSANT(0, 6, 150, 100),
    PIZZA(25, 5, 250, 80),
    MACARON(50, 4, 100, 60);

    private int matureTemperature;
    private int matureDays;
    private int ovenTemperature;
    private int ovenMinutes;
}
