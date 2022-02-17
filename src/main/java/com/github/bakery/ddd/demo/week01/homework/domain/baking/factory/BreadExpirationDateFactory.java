package com.github.bakery.ddd.demo.week01.homework.domain.baking.factory;

import java.time.OffsetDateTime;

public class BreadExpirationDateFactory {

    public static OffsetDateTime getExpirationDate(String breadName) {
        // 크로아상 3일, 소보루 5일, 피자빵 2일, 마카롱 7일
        if ("Croissant".equals(breadName)) {
            return OffsetDateTime.now().plusDays(3L);
        } else if ("Streusel".equals(breadName)) {
            return OffsetDateTime.now().plusDays(5L);
        } else {
            throw new IllegalArgumentException("It is a type of bread whose expiration date cannot be set. bread Name : " + breadName);
        }
    }

}
