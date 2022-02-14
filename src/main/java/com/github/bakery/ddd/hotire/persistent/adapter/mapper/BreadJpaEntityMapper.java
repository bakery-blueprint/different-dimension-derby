package com.github.bakery.ddd.hotire.persistent.adapter.mapper;

import org.mapstruct.factory.Mappers;

import com.github.bakery.ddd.hotire.domain.bread.Bread;
import com.github.bakery.ddd.hotire.domain.bread.BreadStatus;
import com.github.bakery.ddd.hotire.persistent.entity.BreadJpaEntity;

//@Mapper
public interface BreadJpaEntityMapper {
    BreadJpaEntityMapper INSTANCE = Mappers.getMapper(BreadJpaEntityMapper.class);

    Bread toDomain(BreadJpaEntity entity);

    BreadJpaEntity toJpaEntity(Bread bread);

    default int convert(BreadStatus status) {
        return status.getOrder();
    }

    default BreadStatus convert(int order) {
        return BreadStatus.findByOrder(order);
    }
}
