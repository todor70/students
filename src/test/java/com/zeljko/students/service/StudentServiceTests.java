package com.zeljko.students.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import com.zeljko.students.entity.Student;
import com.zeljko.students.repository.StudentRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    /*@Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void list(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("mare","maric","mare@gmail.com"));
        studentList.add(new Student("pera","peric","pera@gmail.com"));
        when(studentRepository.findAll()).thenReturn(studentList);

        List<Student> result = Lists.newArrayList(studentService.list());
        assertEquals(2, result.size());
    }

    @Test
    public void delete(){
        studentService.delete(3L);
        verify(studentRepository, times(1)).deleteById(3L);
    }


}