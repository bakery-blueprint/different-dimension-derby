package com.github.bakery.ddd.hotire.domain.order;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggingOrderedEventListener implements OrderedEventListener {
    @Override
    public void onBreadSoldEvent(OrderedEvent event) {
        log.info("event : {}", event);
    }
}
