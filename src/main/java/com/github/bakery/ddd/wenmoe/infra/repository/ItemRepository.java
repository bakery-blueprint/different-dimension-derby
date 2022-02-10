package com.github.bakery.ddd.wenmoe.infra.repository;

import com.github.bakery.ddd.wenmoe.domain.Item;

public interface ItemRepository {
    Item findById(String id);

    void save(Item item);
}
