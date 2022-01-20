package com.github.bakery.ddd.yun0.week01.application;

import com.github.bakery.ddd.yun0.week01.domain.bread.Bread;
import com.github.bakery.ddd.yun0.week01.domain.bread.BreadRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BreadService {
    private final BreadRepository breadRepository;

    public Bread bake() {
        return null;
    }
}
