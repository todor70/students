package com.zeljko.students.repository;

import com.zeljko.students.entity.Course;
import org.assertj.core.util.IterableUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryDataJpaTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findAllCourses() throws Exception{
        Iterable<Course> courses = courseRepository.findAll();
        assertEquals(5, IterableUtil.sizeOf(courses));
    }

    @Test
    public void findCourseById() throws Exception{
        Course course = courseRepository.findById(1L).get();
        assertEquals("java",course.getTitle());
    }

}
