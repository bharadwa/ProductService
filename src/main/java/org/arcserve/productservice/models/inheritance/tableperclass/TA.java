package org.arcserve.productservice.models.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name ="tpc_ta")
public class TA extends User {

    private int numberOfSessions;
}
