package com.github.bakery.ddd.hotire.domain;

import java.util.Optional;

public interface BreadRepository {
    Optional<Bread> findById(Long id);
}
