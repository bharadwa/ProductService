package org.arcserve.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -706191072523928751L;

    // Common fields can be added here, such as ID, createdAt, updatedAt, etc.
    private Long id;
    private String createdAt;
    private String updatedAt;


}
