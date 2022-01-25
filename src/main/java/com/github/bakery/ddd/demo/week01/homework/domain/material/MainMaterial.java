package com.github.bakery.ddd.demo.week01.homework.domain.material;

import com.github.bakery.ddd.demo.week01.homework.value.MainMaterialStep;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public class MainMaterial {

    private final String name;
    private final MainMaterialStep currentStep;
    private final int amount;
}
