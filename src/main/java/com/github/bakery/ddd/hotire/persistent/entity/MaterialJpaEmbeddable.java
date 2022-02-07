package com.github.bakery.ddd.hotire.persistent.entity;

import javax.persistence.Embeddable;

@Embeddable
public class MaterialJpaEmbeddable {
    private String materialType;
    private String breadStatusOrder;
    private String contentJson;
}
