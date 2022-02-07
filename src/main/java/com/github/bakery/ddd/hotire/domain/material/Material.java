package com.github.bakery.ddd.hotire.domain.material;

import com.github.bakery.ddd.hotire.domain.BreadStatus;
import com.github.bakery.ddd.hotire.util.JsonUtils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public abstract class Material {
    private final BreadStatus breadStatus;
    private final MaterialType materialType;
    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public boolean equalsContext(Material other) {
        return getClass().isInstance(other);
    }
}
