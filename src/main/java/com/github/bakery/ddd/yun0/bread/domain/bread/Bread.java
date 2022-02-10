package com.github.bakery.ddd.yun0.bread.domain.bread;

import com.github.bakery.ddd.yun0.bread.domain.processor.ProcessorFactory;
import com.github.bakery.ddd.yun0.bread.domain.recipe.RecipeFactory;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BreadType type;
    @Enumerated(EnumType.STRING)
    private BreadStatus status;
    @LastModifiedDate
    private LocalDateTime processedDateTime;
    @Version
    private long version;

    public static Bread create(BreadType breadType, ProcessorFactory processorFactory, RecipeFactory recipeFactory) {
        var bread = Bread.builder()
                .type(breadType)
                .status(BreadStatus.INIT)
                .processedDateTime(LocalDateTime.now())
                .build();
        return bread.process(processorFactory, recipeFactory);
    }

    public Bread process(ProcessorFactory processorFactory, RecipeFactory recipeFactory) {
        var processor = processorFactory.getProcessor(status, type);
        var recipe = recipeFactory.getRecipe(type);
        return processor.process(this, recipe);
    }

    public Bread sell() {
        this.status = BreadStatus.SOLD;
        return this;
    }
}
