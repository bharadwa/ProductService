package org.arcserve.productservice.models.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="tpc_instructors")
public class Instructor extends User {

    private String specialization;
    private double avgRating;
}
