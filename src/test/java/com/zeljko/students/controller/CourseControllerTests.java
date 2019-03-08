package com.zeljko.students.controller;

import com.zeljko.students.entity.Course;
import com.zeljko.students.repository.CourseRepository;
import com.zeljko.students.service.CourseService;
import com.zeljko.students.service.CourseServiceImpl;
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
public class CourseControllerTests {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    /*@Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    public void list(){
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("c"));
        courseList.add(new Course("c++"));
        courseList.add(new Course("c#"));
        when(courseService.list()).thenReturn(courseList);
        List<Course> result = Lists.newArrayList(courseController.list());
        assertEquals(3, result.size());
    }

    @Test
    public void create(){
        Course course = new Course("javascript");
        when(courseService.create(course)).thenReturn(course);
        Course result = courseController.create(course);
        assertEquals("javascript", result.getTitle());
    }

    @Test
    public void delete(){
        courseController.delete(3L);
        verify(courseService, times(1)).delete(3L);
    }

}