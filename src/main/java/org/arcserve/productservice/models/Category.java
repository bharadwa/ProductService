package org.arcserve.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="categories")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String value;
}
