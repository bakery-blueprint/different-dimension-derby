package com.github.bakery.ddd.hotire.persistent.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.bakery.ddd.hotire.domain.bread.Bread;
import com.github.bakery.ddd.hotire.domain.bread.BreadRepository;
import com.github.bakery.ddd.hotire.persistent.adapter.mapper.BreadJpaEntityMapper;
import com.github.bakery.ddd.hotire.persistent.repository.BreadJpaEntityRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BreadPersistentAdapter implements BreadRepository {

    private final BreadJpaEntityRepository breadJpaEntityRepository;

    @Override
    public Optional<Bread> findById(Long id) {
        return breadJpaEntityRepository.findById(id)
                                       .map(BreadJpaEntityMapper.INSTANCE::toDomain);
    }
}
