package com.zeljko.students.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import com.zeljko.students.entity.Course;
import com.zeljko.students.repository.CourseRepository;
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
public class CourseServiceTests {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

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
        when(courseRepository.findAll()).thenReturn(courseList);
        List<Course> result = Lists.newArrayList(courseService.list());
        assertEquals(3, result.size());
    }

    @Test
    public void create(){
        Course course = new Course("javascript");
        when(courseRepository.save(course)).thenReturn(course);
        Course result = courseService.create(course);
        assertEquals("javascript", result.getTitle());
    }

    @Test
    public void delete(){
        courseService.delete(3L);
        verify(courseRepository, times(1)).deleteById(3L);
    }

}