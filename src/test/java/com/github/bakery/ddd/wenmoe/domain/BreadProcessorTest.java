package com.github.bakery.ddd.wenmoe.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class BreadProcessorTest {
    @Test
    void test() {
        BreadType pizzaBread = BreadType.PIZZA;
        BreadProcessor processor = new BreadProcessor(new Bread(pizzaBread));

        Dough dough = processor.makeDough(Stream.of(new MainIngredient.Flour(), new MainIngredient.Water(40))
                .collect(Collectors.toCollection(HashSet::new)));

        Mature mature = processor.mature(pizzaBread.getMatureTemperature());
    }
}