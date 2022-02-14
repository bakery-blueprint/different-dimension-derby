package com.github.bakery.ddd.hotire.domain.billing;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Money implements Serializable {
    private BigDecimal value;
}
