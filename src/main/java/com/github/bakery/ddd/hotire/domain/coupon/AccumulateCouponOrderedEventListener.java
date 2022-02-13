package com.github.bakery.ddd.hotire.domain.coupon;

import org.springframework.stereotype.Component;

import com.github.bakery.ddd.hotire.domain.order.OrderedEvent;
import com.github.bakery.ddd.hotire.domain.order.OrderedEventListener;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccumulateCouponOrderedEventListener implements OrderedEventListener {

    private final CouponRepository repository;

    @Override
    public void onBreadSoldEvent(OrderedEvent event) {
        repository.findByAccountId(event.getOrder().getAccount().getId())
                  .ifPresentOrElse(
                          Coupon::accumulate,
                          () -> repository.save(Coupon.of(event.getOrder().getAccount().getId()))
                  );
    }
}
