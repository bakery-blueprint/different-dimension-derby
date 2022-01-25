package com.github.bakery.ddd.yun0.week01.domain;

import com.github.bakery.ddd.yun0.week01.domain.flour.Flour;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Ingredients {
    private final Set<Flour> flours;

    @Override
    public String toString() {
        return flours.stream().map(Flour::toString).collect(Collectors.joining(", "));
    }
}
