package com.github.bakery.ddd.wenmoe.infra.repository;

import com.github.bakery.ddd.wenmoe.domain.BreadType;
import com.github.bakery.ddd.wenmoe.domain.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaItemRepository implements ItemRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item findById(String id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    public void save(Item item) {
        entityManager.persist(item);
    }
}
