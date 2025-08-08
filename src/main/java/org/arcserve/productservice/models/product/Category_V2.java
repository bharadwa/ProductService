package org.arcserve.productservice.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.arcserve.productservice.models.BaseEntity;

import java.util.List;

@Getter
@Setter
@Entity(name="categories_v2")
public class Category_V2 extends BaseEntity {

    private String value;
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categoryV2")
    List<ProductV2> products;
}
