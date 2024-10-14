package ru.lisenkova.main;

import jakarta.persistence.*;
import lombok.ToString;

@ToString
@Entity
@Table(name = "Employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeBD {
    @Id
    @Column(name = "id")
    Integer IDBD;
    @Column(name = "name")
    String nameBD;
    @Column(name = "DepartmentID")
    String departmentIDBD;

}
