package com.github.bakery.ddd.wenmoe.infra.repository;

import com.github.bakery.ddd.wenmoe.domain.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

}
