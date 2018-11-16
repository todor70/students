package com.zeljko.students.repository;

import com.zeljko.students.entity.Student;
import org.assertj.core.util.IterableUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryDataJpaTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void findAllStudents() throws Exception{
        Iterable<Student> students = studentRepository.findAll();
        assertEquals(4, IterableUtil.sizeOf(students));
    }

    @Test
    public void findStudentById() throws Exception{
        Student student = studentRepository.findById(1L).get();
        assertEquals("marko",student.getFirstName());
        assertEquals("markovic", student.getLastName());
        assertEquals("marko@gmail.com", student.getEmail());
    }

}
