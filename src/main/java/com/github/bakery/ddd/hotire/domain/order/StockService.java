package com.github.bakery.ddd.hotire.domain.order;

import com.github.bakery.ddd.hotire.domain.bread.BreadType;

public interface StockService {
    Stock getStock(BreadType breadType);
    Stock save(Stock stock);
}
