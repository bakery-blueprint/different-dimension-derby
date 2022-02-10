package com.github.bakery.ddd.hotire.domain.bread;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BreadStatus {
    NONE(0),
    PREPARED(1),
    DOUGH(2),
    FERMENTED(3),
    BAKE(4),
    DECORATE(5);

    private final int order;

    private static final Map<Integer, BreadStatus> MAP_BY_ORDER = Arrays.stream(BreadStatus.values()).collect(Collectors.toMap(BreadStatus::getOrder, Function.identity()));

    public static BreadStatus findByOrder(int order) {
        return MAP_BY_ORDER.get(order);
    }
}
