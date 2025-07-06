package org.arcserve.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String value;
}
