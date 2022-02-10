package com.github.bakery.ddd.yun0.ingredient.domain.ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private IngredientType type;
    private int amount;
    @Enumerated(EnumType.STRING)
    private AmountUnitType amountUnitType;
}
