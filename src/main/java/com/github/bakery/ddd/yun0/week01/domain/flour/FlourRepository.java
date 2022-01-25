package com.github.bakery.ddd.yun0.week01.domain.flour;

import java.util.Set;

public interface FlourRepository {
    Set<Flour> findAll();
}
