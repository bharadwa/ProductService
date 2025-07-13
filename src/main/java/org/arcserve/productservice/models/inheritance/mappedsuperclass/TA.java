package org.arcserve.productservice.models.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name ="msc_ta")
public class TA extends User {

    private int numberOfSessions;
}
