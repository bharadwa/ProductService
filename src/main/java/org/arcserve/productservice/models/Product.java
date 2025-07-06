package org.arcserve.productservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.xml.catalog.Catalog;

@Getter
@Setter
public class Product extends BaseEntity{

    private String name;
    private String description;
    private String title;
    private Double price;
    private Category category;

}
