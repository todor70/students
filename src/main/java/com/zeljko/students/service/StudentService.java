package com.zeljko.students.service;

import com.zeljko.students.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> list();

    Student create(Student student);

    Student read(long id);

    Student update(long id, Student student);

    Student patch(long id, Student student);

    void delete(long id);
}
