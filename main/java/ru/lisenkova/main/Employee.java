package ru.lisenkova.main;

import jakarta.persistence.*;
import lombok.ToString;


@ToString
@Entity
public class Employee {
        @Id
        Integer ID;
        String name;
        String departmentID;
}
