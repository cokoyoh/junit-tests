package com.unittesting.unittest;

import com.unittesting.unittest.employees.Employee;
import com.unittesting.unittest.employees.EmployeeService;
import com.unittesting.unittest.employees.EmployeesRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class EmployeeServiceTest {

    @Mock
    private EmployeesRepository employeesRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void shouldReturnEmployeeGivenAnEmployeeName2() {
        Employee operationDude = new Employee("John Doe");

        when(employeesRepository.save(operationDude))
                .thenReturn(operationDude);

        Employee found = employeeService.getEmployeeByName(operationDude.getName());

        assertEquals(found.getName(), operationDude.getName());
    }

    @Test
    public void shouldSaveAnInstanceOfUser() {
        Employee employee1 = new Employee("M. Yass");

        when(employeesRepository.save(employee1)).thenReturn(employee1);

        Employee savedEmployee = employeeService.save(employee1);

        assertEquals(savedEmployee.getName(), employee1.getName());
    }
}
