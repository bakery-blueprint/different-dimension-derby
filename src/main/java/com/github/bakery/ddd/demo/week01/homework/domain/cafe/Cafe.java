package com.github.bakery.ddd.demo.week01.homework.domain.cafe;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;
import com.github.bakery.ddd.demo.week01.homework.domain.customer.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Cafe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cafe_balance")
    private int cafeBalance;

    @ElementCollection
    @CollectionTable(name = "bread_stock",
                     joinColumns = @JoinColumn(name = "cafe_id"))
    private List<Bread> breads = new ArrayList<>();

    public void addBreadStock(final List<Bread> breadStock) {
        breads.addAll(breadStock);
    }

    public Bag buyBread(Customer customer, String breadName, int amount) {
        List<Bread> saleAvailableBreads = breads.stream()
                                                .filter(it -> it.getName().equals(breadName))
                                                .sorted(Comparator.comparing(Bread::getExpirationDate))
                                                .collect(Collectors.toList());

        List<Bread> returnBreads = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            returnBreads.add(saleAvailableBreads.get(i));
        }

        int totalBreadPrice = returnBreads.stream()
                                          .mapToInt(this::getBreadPrice)
                                          .sum();

        if (customer.getCoupon().isFillUp()) {
            returnBreads.add(saleAvailableBreads.remove(0));
        }

        cafeBalance += customer.payForBread(totalBreadPrice);
        this.breads.removeAll(returnBreads);
        customer.addBread(returnBreads);
        return new Bag(returnBreads, 0);
    }

    private void verifyBreadStock(List<Bread> breadStock) {
        breadStock.stream()
                  .findAny()
                  .orElseThrow(() -> new IllegalStateException("There are breads that are not priced."));
    }

    public Bag buyBread(final String bradName, final int money, final int amount) {

        List<Bread> returnBreads = new ArrayList<>();

        int numberOfPurchases = amount;
        int changeMoney = money;

        for (Bread bread : breads) {
            verifyMoneyToBuyBread(changeMoney, numberOfPurchases);
            if (isPurchasable(bradName, changeMoney, numberOfPurchases, bread)) {
                returnBreads.add(bread);
                numberOfPurchases--;
                changeMoney = changeMoney - getBreadPrice(bread);
            }
        }
        verifyPurchase(numberOfPurchases);
        breads.removeAll(returnBreads);
        return new Bag(returnBreads, Math.round(changeMoney));
    }

    private void verifyPurchase(int numberOfPurchases) {
        if (numberOfPurchases > 0) {
            throw new IllegalStateException("Out of bread stock.");
        }
    }

    private int getBreadPrice(Bread bread) {

        double price;
        if (bread.getExpirationDate().plusDays(1).isAfter(OffsetDateTime.now())) {
            price = bread.getPrice() * 0.8;
        } else {
            price = bread.getPrice();
        }

        return (int) Math.round(price);
    }

    private boolean isPurchasable(String bradName, int money, int amount, Bread bread) {
        return bread.getName().equals(bradName) && getBreadPrice(bread) <= money && amount >= 0;
    }

    private void verifyMoneyToBuyBread(int money, int numberOfPurchases) {
        if (money <= 0 && numberOfPurchases > 0) {
            throw new IllegalStateException("It doesn't have enough money.");
        }
    }
}
