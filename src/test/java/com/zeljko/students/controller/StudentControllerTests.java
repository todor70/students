package com.zeljko.students.controller;

import com.zeljko.students.entity.Student;
import com.zeljko.students.repository.StudentRepository;
import com.zeljko.students.service.StudentService;
import com.zeljko.students.service.StudentServiceImpl;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTests {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    /*@Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void list(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("mare","maric","mare@gmail.com"));
        studentList.add(new Student("pera","peric","pera@gmail.com"));
        when(studentService.list()).thenReturn(studentList);

        List<Student> result = Lists.newArrayList(studentController.list());
        assertEquals(2, result.size());
    }

    @Test
    public void delete(){
        studentController.delete(3L);
        verify(studentService, times(1)).delete(3L);
    }


}