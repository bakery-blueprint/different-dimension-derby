package com.github.bakery.ddd.yun0.customer.domain.order;

import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long customerId;
    private BreadType breadType;
    private Integer quantity;

    public Integer getAllPrice() {
        return breadType.getPrice() * quantity;
    }
}
