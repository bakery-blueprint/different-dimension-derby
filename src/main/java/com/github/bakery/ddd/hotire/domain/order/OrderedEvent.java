package com.github.bakery.ddd.hotire.domain.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderedEvent {
    private final Order order;
}
