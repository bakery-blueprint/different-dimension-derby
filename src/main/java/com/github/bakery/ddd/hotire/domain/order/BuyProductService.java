package com.github.bakery.ddd.hotire.domain.order;

import com.github.bakery.ddd.hotire.domain.account.Account;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuyProductService {

    private final StockService stockService;

    public void buy(Account account, Product product) {
        final Stock stock = stockService.getStock(product.getBread().getBreadType());
        stock.buy(1);
        account.buy(product.getPrice());
    }

}
