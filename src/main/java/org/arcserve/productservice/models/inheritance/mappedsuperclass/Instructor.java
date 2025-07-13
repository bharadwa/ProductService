package org.arcserve.productservice.models.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="msc_instructors")
public class Instructor extends User {

    private String specialization;
    private double avgRating;
}
