package com.unittesting.unittest;

import com.unittesting.unittest.employees.Employee;
import com.unittesting.unittest.employees.EmployeeService;
import com.unittesting.unittest.employees.EmployeesController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeesController.class)
public class EmployeeIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void shouldReturnListOfAllEmployees() throws Exception{
        Employee employee = new Employee("John Doe");

        List<Employee> allEmployees = Arrays.asList(employee);

        given(employeeService.getAllEmployees()).willReturn(allEmployees);

        mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is(employee.getName())));
    }
}
