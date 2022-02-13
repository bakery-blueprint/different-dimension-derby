package com.github.bakery.ddd.hotire.domain.order;

import org.springframework.context.event.EventListener;

public interface OrderedEventListener {

    @EventListener
    void onBreadSoldEvent(OrderedEvent event);
}
