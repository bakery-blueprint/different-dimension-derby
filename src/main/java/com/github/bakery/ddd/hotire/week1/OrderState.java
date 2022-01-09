package com.github.bakery.ddd.hotire.week1;

public enum OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED,
    DELIVERING,
    DELIVERY_COMPLETED,
    CANCELED;
}
