package com.github.bakery.ddd.hotire.week2.domain.material;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.github.bakery.ddd.hotire.week2.domain.material.FlourMaterial.Almond;
import com.github.bakery.ddd.hotire.week2.domain.material.FlourMaterial.Wheat;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

class DoughTest {

    @TestFactory
    Stream<DynamicTest> create() {
        @ToString
        @RequiredArgsConstructor
        class TestCase {
            private final List<DoughMaterial> materials;
            private final Class<? extends Throwable> expectedError;
            private final Dough expected;

            public boolean isError() {
                return expectedError != null;
            }
        }

        return Stream.of(new TestCase(List.of(), IllegalArgumentException.class, null),
                         new TestCase(List.of(mock(Flour.class)), IllegalArgumentException.class, null),
                         new TestCase(List.of(new Flour(List.of(new Almond(), new Wheat())), new Water(46.0)), null, new Dough(List.of(new Flour(List.of(new Almond(), new Wheat())), new Water(46.0))))
        ).map(it -> DynamicTest.dynamicTest("create, case : " + it, () -> {
            // when
            if (it.isError()) {
                assertThatThrownBy(() -> new Dough(it.materials)).isInstanceOf(it.expectedError);
                return;
            }
            var result = new Dough(it.materials);

            // then
            assertThat(result.getFlour()).isEqualTo(it.expected.getFlour());
            assertThat(result.getWater().getTemperature()).isEqualTo(it.expected.getWater().getTemperature());
        }));
    }

}