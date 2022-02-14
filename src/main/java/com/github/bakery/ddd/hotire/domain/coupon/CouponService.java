package com.github.bakery.ddd.hotire.domain.coupon;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public boolean isCollect(Long accountId) {
        return couponRepository.findByAccountId(accountId).map(Coupon::isCollect).orElseGet(() -> false);
    }
}
