package com.github.bakery.ddd.demo.week01.homework.domain.baking.recipe;

import com.github.bakery.ddd.demo.week01.homework.domain.baking.BakingStep;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.Temperature;
import com.github.bakery.ddd.demo.week01.homework.domain.baking.bakingprecess.BakingProcess;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
abstract public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fermentTime;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "ferment_temperature"))
    @AttributeOverride(name = "unit", column = @Column(name ="ferment_temperature_unit"))
    private Temperature fermentTemperature;

    private int bakeTime;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "bake_temperature"))
    @AttributeOverride(name = "unit", column = @Column(name ="bake_temperature_unit"))
    private Temperature bakeTemperature;

    @ElementCollection
    @CollectionTable(name = "recipe_main_material",
                     joinColumns = @JoinColumn(name = "recipe_id"))
    @OrderColumn(name = "line_idx")
    private List<RecipeMainMaterial> recipeMainMaterials;

    @ElementCollection
    @CollectionTable(name = "recipe_main_material",
                     joinColumns = @JoinColumn(name = "recipe_id"))
    @OrderColumn(name = "line_idx")
    private List<RecipeSubMaterial> recipeSubMaterials;

    protected Recipe(int fermentTime, Temperature fermentTemperature
        , int bakeTime, Temperature bakeTemperature
        , List<RecipeMainMaterial> recipeMainMaterials, List<RecipeSubMaterial> recipeSubMaterials) {
        this.fermentTime = fermentTime;
        this.fermentTemperature = fermentTemperature;
        this.bakeTime = bakeTime;
        this.bakeTemperature = bakeTemperature;
        this.recipeMainMaterials = recipeMainMaterials;
        this.recipeSubMaterials = recipeSubMaterials;
    }

    abstract public BakingProcess getProcess(BakingStep step);
}
