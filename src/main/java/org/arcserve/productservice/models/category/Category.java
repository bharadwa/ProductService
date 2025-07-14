package org.arcserve.productservice.models.category;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.arcserve.productservice.models.BaseEntity;

@Getter
@Setter
@Entity(name="categories")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String value;
}
