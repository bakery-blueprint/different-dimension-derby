package com.github.bakery.ddd.wenmoe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

// 생산된 빵이 아닌... 마트 가서 야채코너가면 정량만큼 담고 포스기에서 아이템 선택하는....그런.....
// 네이밍 죄송합니다;
@AllArgsConstructor
@Getter
@Entity
public class Item {
    @Id
    private String id;

    @Column
    private BreadType breadType;

    @Column
    private Money price;

    @Column
    private int stock;  // 재고

    public void plusStock(int plusStock) {
        this.stock += plusStock;
    }

    public void minusStock(int minusStock) {
        compareStock(minusStock);

        this.stock -= minusStock;
    }

    public void compareStock(int compareStock) {
        if (compareStock > this.stock) {
            throw new IllegalArgumentException("out of stock!");
        }
    }
}
