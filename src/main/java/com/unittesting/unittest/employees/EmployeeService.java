package com.unittesting.unittest.employees;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService{
    @Autowired
    private EmployeesRepository employeesRepository;

    public Employee getEmployeeByName(String name) {
        return employeesRepository.findEmployeeByName(name);
    }

    public Employee save(Employee employee) {
        return employeesRepository.save(employee);
    }

    public Optional<Employee> findById(int id) {
        return employeesRepository.findById((long) id);
    }

    public List<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }
}
