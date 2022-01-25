package com.github.bakery.ddd.hotire.persistent.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.bakery.ddd.hotire.domain.Bread;
import com.github.bakery.ddd.hotire.persistent.entity.BreadJpaEntity;

@Mapper
public interface BreadJpaEntityMapper {
    BreadJpaEntityMapper INSTANCE = Mappers.getMapper(BreadJpaEntityMapper.class);
    Bread toDomain(BreadJpaEntity entity);
    BreadJpaEntity toJpaEntity(Bread bread);
}
