package org.arcserve.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract  class BaseEntity implements Serializable {

    private static final long serialVersionUID = -706191072523928751L;

    // Common fields can be added here, such as ID, createdAt, updatedAt, etc.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdAt;
    private String updatedAt;


}
