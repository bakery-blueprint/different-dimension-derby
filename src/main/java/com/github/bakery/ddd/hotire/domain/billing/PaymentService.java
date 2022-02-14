package com.github.bakery.ddd.hotire.domain.billing;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.github.bakery.ddd.hotire.domain.coupon.CouponService;
import com.github.bakery.ddd.hotire.domain.order.Product;
import com.github.bakery.ddd.hotire.domain.order.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final CouponService couponService;
    private final ProductService productService;

    void payment(Payment payment) {
        if (couponService.isCollect(payment.getAccountId())) {
            productService.findOneOrderByExpirationDate()
                          .map(Product::forFree)
                          .ifPresentOrElse(it -> payment.getOrder().getProducts().add(it), () -> payment.doSale(BigDecimal.valueOf(0.9)));
        }
    }
}
