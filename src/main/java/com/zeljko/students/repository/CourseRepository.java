package com.zeljko.students.repository;

import com.zeljko.students.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Course findByTitle(String title);
}
