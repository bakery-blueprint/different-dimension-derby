package com.github.bakery.ddd.demo.week01.homework.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class BlendingRecipe {

    public static final int MAX_MAIN_MATERIAL_COUNT = 2;

    private List<MainMaterialAndRatio> mainMaterialAndRatios = new ArrayList<>();

    public void addMainMaterialAndRatio(MainMaterial mainMaterial, int ratio){
        if(mainMaterialAndRatios.isEmpty()) {
            new MainMaterialAndRatio(mainMaterial, ratio);
            return;
        }
        verifyMainMaterialAddable();
        mainMaterialAndRatios.add(new MainMaterialAndRatio(mainMaterial, ratio));
    }

    private void verifyMainMaterialAddable() {
        if(MAX_MAIN_MATERIAL_COUNT > mainMaterialAndRatios.size()) {
            throw new IllegalStateException("The number of main material cannot exceed " + MAX_MAIN_MATERIAL_COUNT);
        }
    }

    @Getter
     class MainMaterialAndRatio {
         private final MainMaterial mainMaterial;
         private final int ratio;

         public MainMaterialAndRatio(final MainMaterial mainMaterial, final int ratio) {
             this.mainMaterial = mainMaterial;
             this.ratio = ratio;
         }
    }
}
