package com.github.bakery.ddd.yun0.bread.domain.bread;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreadRepository extends JpaRepository<Bread, Long> {
    List<Bread> findAllByTypeAndStatusOrderByProcessedDateTime(BreadType type, BreadStatus breadStatus);
}
