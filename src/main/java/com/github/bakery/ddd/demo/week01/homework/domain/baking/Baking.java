package com.github.bakery.ddd.demo.week01.homework.domain.baking;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.material.Material;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe.Recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

    @ElementCollection
    @CollectionTable(name = "main_material",
                     joinColumns = @JoinColumn(name = "baking_id"))
    @OrderColumn(name = "line_idx")
    private List<Material> mainMaterial = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "sub_material",
                     joinColumns = @JoinColumn(name = "baking_id"))
    @OrderColumn(name = "line_idx")
    private List<Material> subMaterial;

    public Baking(final Recipe breadRecipe, List<Material> mainMaterial, List<Material> subMaterial) {
        this.mainMaterial = mainMaterial;
        this.subMaterial = subMaterial;
        this.breadRecipe = breadRecipe;
        BakingProcess process = breadRecipe.getProcess(BakingStep.PREPARE);
        this.bread = process.process(this.breadRecipe, mainMaterial, subMaterial);
    }

    public void processNextStep(List<Material> mainMaterial, List<Material> subMaterial) {
        BakingProcess process = breadRecipe.getProcess(bread.getCurrentBakingStep().getNextStep());
        this.bread = process.process(this.breadRecipe, mainMaterial, subMaterial);
    }

    public Bread createBread() {
        processNextStep(this.mainMaterial, this.subMaterial);
        processNextStep(this.mainMaterial, this.subMaterial);
        processNextStep(this.mainMaterial, this.subMaterial);
        processNextStep(this.mainMaterial, this.subMaterial);
        processNextStep(this.mainMaterial, this.subMaterial);

        return this.bread;
    }
}
