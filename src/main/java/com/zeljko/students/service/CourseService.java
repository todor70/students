package com.zeljko.students.service;

import com.zeljko.students.entity.Course;

public interface CourseService {

    Iterable<Course> list();

    Course create(Course course);

    Course read(long id);

    Course update(long id, Course course);

    Course patch(long id, Course course);

    void delete(long id);

}
