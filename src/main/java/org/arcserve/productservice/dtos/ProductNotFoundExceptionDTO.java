package org.arcserve.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductNotFoundExceptionDTO {
    private String message;
    private String resolution;
}
