package com.github.bakery.ddd.demo.week01.homework.domain.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.bakery.ddd.demo.week01.homework.domain.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
