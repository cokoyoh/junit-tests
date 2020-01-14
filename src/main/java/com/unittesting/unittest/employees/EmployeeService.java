package com.unittesting.unittest.employees;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService{
    @Autowired
    private EmployeesRepository employeesRepository;

    public Employee getEmployeeByName(String name) {
        return employeesRepository.findEmployeeByName(name);
    }

    public Employee save(Employee employee) {
        return employeesRepository.save(employee);
    }
}
