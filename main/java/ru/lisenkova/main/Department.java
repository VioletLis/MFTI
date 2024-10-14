package ru.lisenkova.main;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.ToString;

@ToString
@Entity
public class Department {
    @Id
    Integer id;
    String name;

}
