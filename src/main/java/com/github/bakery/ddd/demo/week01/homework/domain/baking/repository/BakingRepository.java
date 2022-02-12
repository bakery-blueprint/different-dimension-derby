package com.github.bakery.ddd.demo.week01.homework.domain.baking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Baking;

@Repository
public interface BakingRepository extends JpaRepository<Baking, Long> {
}
