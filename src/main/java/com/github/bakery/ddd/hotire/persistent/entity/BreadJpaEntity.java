package com.github.bakery.ddd.hotire.persistent.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.github.bakery.ddd.hotire.domain.bread.BreadType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BreadJpaEntity extends AbstractAggregateRoot<BreadJpaEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @ElementCollection
    @CollectionTable(name = "material", joinColumns = @JoinColumn(name = "bread_id"))
    @OrderColumn(name = "bread_status_order")
    private List<MaterialJpaEmbeddable> materials;
    @Enumerated
    private BreadType breadType;
    private Instant createdDate;
    private Instant modifiedDate;
}
