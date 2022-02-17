package com.github.bakery.ddd.demo.week01.homework.domain.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Getter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "coupon",
                     joinColumns = @JoinColumn(name = "coupon_id"))
    @OrderColumn(name = "line_idx")
    private List<Boolean> stamp = new ArrayList<>();

    public boolean isFillUp() {
        if (stamp == null || stamp.isEmpty()) {
            return false;
        }

        if (stamp.size() < 10) {
            return false;
        }

        int fillCount = 0;

        for (Boolean aBoolean : stamp) {
            if (aBoolean) {
                fillCount++;
                continue;
            }
            break;
        }
        return fillCount >= 10;
    }
}
