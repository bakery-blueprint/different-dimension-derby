package com.github.bakery.ddd.yun0.bread.application;

import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import com.github.bakery.ddd.yun0.bread.domain.processor.ProcessorFactory;
import com.github.bakery.ddd.yun0.bread.domain.bread.Bread;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadRepository;
import com.github.bakery.ddd.yun0.bread.domain.recipe.RecipeFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BreadService {
    private final BreadRepository breadRepository;
    private final ProcessorFactory processorFactory;
    private final RecipeFactory recipeFactory;

    public List<Bread> getBreads() {
        return breadRepository.findAll();
    }

    @Transactional
    public Bread create(BreadType breadType) {
        var bread = Bread.create(breadType, processorFactory, recipeFactory);
        return breadRepository.save(bread);
    }

    @Transactional
    public Bread process(Long id) {
        return breadRepository.findById(id)
                .map(bread -> bread.process(processorFactory, recipeFactory))
                .map(breadRepository::save)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 빵입니다."));
    }
}
