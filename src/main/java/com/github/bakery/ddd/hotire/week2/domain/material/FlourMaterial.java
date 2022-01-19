package com.github.bakery.ddd.hotire.week2.domain.material;

import java.time.Duration;

import lombok.Data;

public interface FlourMaterial extends Material {

    default Duration getDuration() {
        return Duration.ZERO;
    }

    @Data
    class Almond implements FlourMaterial {

        @Override
        public Duration getDuration() {
            return Duration.ofDays(1);
        }
    }

    @Data
    class Rice implements FlourMaterial {

        @Override
        public Duration getDuration() {
            return Duration.ofDays(3);
        }
    }

    @Data
    class Wheat implements FlourMaterial {

    }

    @Data
    class Buckwheat implements FlourMaterial {

    }
}
