package com.unittesting.unittest.employees;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 20)
    private String name;

    public Employee() {
    }

    public Employee(@Size(min = 2, max = 20) String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
