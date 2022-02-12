package com.github.bakery.ddd.demo.week01.homework.domain.customer;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.Bread;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int money;

    @ElementCollection
    @CollectionTable(name = "breads",
                     joinColumns = @JoinColumn(name = "customer_id"))
    @OrderColumn(name = "line_idx")
    private List<Bread> breads;

    public Integer payForBread(int breadPrice, int amount) {
        verifyMoney(breadPrice, amount);

        money = money - breadPrice * amount;
        return breadPrice * amount;
    }

    public void addBread(List<Bread> breads) {
        this.breads.addAll(breads);
    }

    private void verifyMoney(int breadPrice, int amount) {
        if (money < breadPrice * amount) {
            throw new IllegalArgumentException("lack of balance.");
        }
    }
}
