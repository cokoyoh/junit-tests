package com.unittesting.unittest;

import com.unittesting.unittest.employees.Employee;
import com.unittesting.unittest.employees.EmployeesRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeesTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Test
    public void shouldReturnEmployeeWhenFindByNameIsEvoked()
    {
        Employee alex = new Employee("Alex");

        testEntityManager.persist(alex);

        testEntityManager.flush(); //you can use persistAndFlush instead

        Employee found = employeesRepository.findEmployeeByName(alex.getName());

        assertEquals(found.getName(), alex.getName());
    }

}
