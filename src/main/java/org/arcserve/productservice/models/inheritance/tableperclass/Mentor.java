package org.arcserve.productservice.models.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_mentors")
public class Mentor extends User {

    private String company;
}
