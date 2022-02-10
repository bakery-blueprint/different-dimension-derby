package com.github.bakery.ddd.yun0.bread.domain.processor;

import com.github.bakery.ddd.yun0.bread.domain.bread.BreadType;
import com.github.bakery.ddd.yun0.bread.domain.bread.BreadStatus;

public interface ProcessorFactory {
    Processor getProcessor(BreadStatus breadStatus, BreadType breadType);
}
