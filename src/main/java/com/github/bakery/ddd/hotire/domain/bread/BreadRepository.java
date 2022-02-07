package com.github.bakery.ddd.hotire.domain.bread;

import java.util.Optional;

public interface BreadRepository {
    Optional<Bread> findById(Long id);
}
