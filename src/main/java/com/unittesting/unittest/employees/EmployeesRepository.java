package com.unittesting.unittest.employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    public Employee findEmployeeByName(String name);
}
