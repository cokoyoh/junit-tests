package com.unittesting.unittest.employees;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService implements EmployeeServiceInterface{
    @Autowired
    private EmployeesRepository employeesRepository;

    public Employee getEmployeeByName(String name) {
        return employeesRepository.findEmployeeByName(name);
    }
}
