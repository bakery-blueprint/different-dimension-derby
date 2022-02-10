package com.github.bakery.ddd.yun0.customer.domain.customer;

import com.github.bakery.ddd.yun0.customer.domain.order.Order;
import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer money;

    public List<Bread> order(Order order, BiFunction<BreadType, BreadStatus, List<Bread>> findAllByStatusOrderByProcessedDateTime) {
        if (money < order.getAllPrice()) {
            throw new IllegalStateException("돈이 부족합니다.");
        }
        var availableBreads = findAllByStatusOrderByProcessedDateTime.apply(order.getBreadType(), BreadStatus.DECORATED);
        if (order.getQuantity() > availableBreads.size()) {
            throw new IllegalStateException("재고수량이 부족합니다.");
        }
        return availableBreads.stream()
                .limit(order.getQuantity())
                .map(Bread::sell)
                .collect(Collectors.toList());
    }
}
