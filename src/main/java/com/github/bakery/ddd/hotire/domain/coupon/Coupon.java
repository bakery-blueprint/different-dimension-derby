package com.github.bakery.ddd.hotire.domain.coupon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Coupon {
    @Id @GeneratedValue
    private Long id;
    private Long accountId;
    private int count;

    public static Coupon of(Long accountId) {
        final Coupon coupon = new Coupon();
        coupon.setAccountId(accountId);
        return coupon;
    }

    public boolean isCollect() {
        return count == 10;
    }

    public Coupon accumulate() {
        count++;
        return this;
    }
}
