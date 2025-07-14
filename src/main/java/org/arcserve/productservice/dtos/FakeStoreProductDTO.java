package org.arcserve.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDTO {

    private Long id;
    private String name;
    private String description;
    private String title;
    private Double price;
    private String category;
    private String image;
}
