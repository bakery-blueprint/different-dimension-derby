package com.github.bakery.ddd.hotire.domain.order;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.github.bakery.ddd.hotire.domain.account.Account;
import com.github.bakery.ddd.hotire.domain.billing.Money;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Order extends AbstractAggregateRoot<Order> {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Product> products;

    @OneToOne
    private Account account;

    public int getQuantity() {
        return products.size();
    }

    public BigDecimal totalPrice() {
        return products.stream()
                       .map(Product::getPrice)
                       .map(Money::getValue)
                       .reduce(BigDecimal::add)
                       .orElse(BigDecimal.ZERO);
    }

    public Order ordered() {
        registerEvent(new OrderedEvent(this));
        return this;
    }

}
