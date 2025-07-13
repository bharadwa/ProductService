package org.arcserve.productservice.models.inheritance.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class TA extends User {

    private int numberOfSessions;
}
