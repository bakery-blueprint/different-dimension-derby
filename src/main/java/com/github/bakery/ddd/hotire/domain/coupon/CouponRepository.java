package com.github.bakery.ddd.hotire.domain.coupon;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByAccountId(Long accountId);
}
