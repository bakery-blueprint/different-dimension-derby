package com.github.bakery.ddd.demo.week01.homework.domain.cafe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Cafe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "bread_stock",
                     joinColumns = @JoinColumn(name = "cafe_id"))
    private List<Bread> breads = new ArrayList<>();

    public void addBreadStock(final List<Bread> breadStock) {
        verifyBreadStock(breadStock);
        breads.addAll(breadStock);
    }

    public int getBreadPrice(String breadName) {
        Bread bread = breads.stream()
                            .filter(it -> it.getName().equals(breadName))
                            .findAny()
                            .orElseThrow(() -> new IllegalArgumentException("The selected bread does not exist."));
        return bread.getPrice();
    }

    private void verifyBreadStock(List<Bread> breadStock) {
        breadStock.stream()
                  .filter(it -> Objects.isNull(it.getPrice()))
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
                changeMoney = changeMoney - bread.getPrice();
            }
        }
        verifyPurchase(numberOfPurchases);
        breads.removeAll(returnBreads);
        return new Bag(returnBreads, changeMoney);
    }

    private void verifyPurchase(int numberOfPurchases) {
        if (numberOfPurchases > 0) {
            throw new IllegalStateException("Out of bread stock.");
        }
    }

    private boolean isPurchasable(String bradName, int money, int amount, Bread bread) {
        return bread.getName().equals(bradName) && bread.getPrice() <= money && amount >= 0;
    }

    private void verifyMoneyToBuyBread(int money, int numberOfPurchases) {
        if (money <= 0 && numberOfPurchases > 0) {
            throw new IllegalStateException("It doesn't have enough money.");
        }
    }
}
