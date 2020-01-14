package com.unittesting.unittest;

import com.unittesting.unittest.employees.Employee;
import com.unittesting.unittest.employees.EmployeeService;
import com.unittesting.unittest.employees.EmployeeServiceInterface;
import com.unittesting.unittest.employees.EmployeesRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
    @TestConfiguration
    static class EmployeeServiceTestConfiguration {
        @Bean
        public EmployeeServiceInterface employeeServiceInterface() {
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeesRepository employeesRepository;

    @Before
    public void setUp() {
        Employee alex = new Employee("alex");

        Mockito.when(employeesRepository.findEmployeeByName(alex.getName()))
                .thenReturn(alex);
    }

    @Test
    public void shouldReturnEmployeeGivenAnEmployeeName2() {
        String name  = "john doe";

        Employee found = employeeService.getEmployeeByName(name);

        System.out.print("Something here");
        System.out.print(found);

        assertEquals(found.getName(), name);
    }
}
