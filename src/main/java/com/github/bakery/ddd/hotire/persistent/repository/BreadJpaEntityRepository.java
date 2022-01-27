package com.github.bakery.ddd.hotire.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.bakery.ddd.hotire.persistent.entity.BreadJpaEntity;

public interface BreadJpaEntityRepository extends JpaRepository<BreadJpaEntity, Long> {
}
