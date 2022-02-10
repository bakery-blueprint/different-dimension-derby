package com.github.bakery.ddd.yun0.bread.infrastructure.processor;

import com.github.bakery.ddd.yun0.bread.domain.bread.BreadStatus;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import com.github.bakery.ddd.yun0.bread.domain.processor.Processor;
import com.github.bakery.ddd.yun0.bread.domain.processor.ProcessorFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultProcessorFactory implements ProcessorFactory {

    @Override
    public Processor getProcessor(BreadStatus breadStatus, BreadType breadType) {
        if (BreadStatus.RIPENED.equals(breadStatus) && BreadType.CROISSANT.equals(breadType)) {
            return new CroissantBakingProcessor();
        }
        return null;
    }
}
