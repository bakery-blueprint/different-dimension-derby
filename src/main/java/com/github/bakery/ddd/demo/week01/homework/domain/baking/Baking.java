package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.Material;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.util.List;

@NoArgsConstructor
@Entity
public class Baking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe breadRecipe;

    @Embedded
    private Bread bread;

    public Baking(final Recipe breadRecipe, List<Material> mainMaterial, List<Material> subMaterial) {
        this.breadRecipe = breadRecipe;
        BakingProcess process = breadRecipe.getProcess(BakingStep.PREPARE);
        this.bread = process.process(this.breadRecipe, mainMaterial, subMaterial);
    }

    public void processNextStep(List<Material> mainMaterial, List<Material> subMaterial) {
        BakingProcess process = breadRecipe.getProcess(bread.getCurrentBakingStep().getNextStep());
        this.bread = process.process(this.breadRecipe, mainMaterial, subMaterial);
    }
}
