package com.zeljko.students.service;

import com.zeljko.students.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> list();

    Course create(Course course);

    Course read(long id);

    Course update(long id, Course course);

    Course patch(long id, Course course);

    void delete(long id);

}
