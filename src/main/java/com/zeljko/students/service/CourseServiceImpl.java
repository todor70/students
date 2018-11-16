package com.zeljko.students.service;

import com.zeljko.students.entity.Course;
import com.zeljko.students.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> list() {
        return courseRepository.findAll();
    }

    @Override
    public Course read(long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(long id, Course courseUpdate) {
        Course course = courseRepository.findById(id).get();

        course.setTitle(courseUpdate.getTitle());

        return courseRepository.save(course);
    }

    @Override
    public Course patch(long id, Course coursePatch) {
        Course course = courseRepository.findById(id).get();

        if (coursePatch.getTitle() != null) {
            course.setTitle(coursePatch.getTitle());
        }
        return courseRepository.save(course);
    }

    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);
    }

}
