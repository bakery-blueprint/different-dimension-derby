package com.github.bakery.ddd.hotire.domain.bread.material;

import java.time.Duration;

import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
public abstract class FlourMaterial extends Material {
    private final Duration duration;

    @Override
    public boolean equalsContext(Material other) {
        if (other instanceof FlourMaterial) {
            return ((FlourMaterial) other).duration == duration;
        }
        return false;
    }

    public FlourMaterial(MaterialType materialType, Duration duration) {
        super(BreadStatus.PREPARED, materialType);
        this.duration = duration;
    }

    static class AlmondFlour extends FlourMaterial {

        public AlmondFlour() {
            super(MaterialType.ALMOND, Duration.ofMinutes(10));
        }
    }

    static class RiceFlour extends FlourMaterial {

        public RiceFlour(MaterialType materialType, Duration duration) {
            super(MaterialType.RICE, Duration.ofMinutes(10));
        }
    }
}
