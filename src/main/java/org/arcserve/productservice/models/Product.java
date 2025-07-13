package org.arcserve.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseEntity{

    private String name;
    private String description;
    private String title;
    private Double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private String image;

}
