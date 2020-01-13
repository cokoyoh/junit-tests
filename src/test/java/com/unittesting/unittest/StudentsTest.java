package com.unittesting.unittest;

import com.unittesting.unittest.students.Student;
import com.unittesting.unittest.students.StudentJpaConfig;
import com.unittesting.unittest.students.StudentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(
        classes = {StudentJpaConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class StudentsTest {
    @Resource
    private StudentsRepository studentsRepository;

    @Test
    public void it_can_store_a_student() {
        Student student = new Student("John Doe");

        studentsRepository.save(student);

        Optional<Student> johnDoe = studentsRepository.findById(1L);

        assertEquals("John Doe", johnDoe.get().getName());
    }
}
