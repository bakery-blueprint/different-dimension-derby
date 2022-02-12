package com.github.bakery.ddd.demo.week01.homework.domain.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.bakery.ddd.demo.week01.homework.domain.cafe.Cafe;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
