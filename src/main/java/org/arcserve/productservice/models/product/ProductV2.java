package org.arcserve.productservice.models.product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.arcserve.productservice.models.BaseEntity;
import org.arcserve.productservice.models.category.Category;

@Getter
@Setter
@Entity(name="products_v2")
public class ProductV2 extends BaseEntity {

    private String name;
    private String description;
    private String title;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category_V2 categoryV2;
    private String image;
}
