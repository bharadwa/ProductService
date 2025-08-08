package org.arcserve.productservice.models.product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.arcserve.productservice.models.BaseEntity;
import org.arcserve.productservice.models.category.Category;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private String title;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Category category;
    private String image;

}
