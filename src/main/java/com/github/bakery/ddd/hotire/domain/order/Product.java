package com.github.bakery.ddd.hotire.domain.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.github.bakery.ddd.hotire.domain.billing.Money;
import com.github.bakery.ddd.hotire.persistent.entity.BreadJpaEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private BreadJpaEntity bread;

    @Embedded
    private Money price;

    private Instant expirationDate;

    public Product forFree() {
        getPrice().setValue(BigDecimal.ZERO);
        return this;
    }

    public Money getPrice() {
        if (getExpirationDate().isAfter(Instant.now().minus(1L, ChronoUnit.DAYS))) {
            return new Money(price.getValue().multiply(BigDecimal.valueOf(0.8)));
        }
        return price;
    }
}
