package com.zeljko.students.service;

import com.zeljko.students.entity.Course;
import com.zeljko.students.entity.Student;
import com.zeljko.students.repository.CourseRepository;
import com.zeljko.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public Student read(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student create(Student student) {

        for (Course c : student.getCourses()) {
            if ((courseRepository.findByTitle(c.getTitle()) == null)) {
                courseRepository.save(c);
            }
        }
        return studentRepository.save(student);
    }

    @Override
    public Student update(long id, Student studentUpdate) {
        Student student = studentRepository.findById(id).get();

        student.setFirstName(studentUpdate.getFirstName());
        student.setLastName(studentUpdate.getLastName());
        student.setEmail(studentUpdate.getEmail());

        for (Course c : studentUpdate.getCourses()) {
            if ((courseRepository.findByTitle(c.getTitle()) == null)) {
                courseRepository.save(c);
            }
        }

        student.setCourses(studentUpdate.getCourses());

        return studentRepository.save(student);
    }

    @Override
    public Student patch(long id, Student studentPatch) {
        Student student = studentRepository.findById(id).get();

        if (studentPatch.getFirstName() != null) {
            student.setFirstName(studentPatch.getFirstName());
        }
        if (studentPatch.getLastName() != null) {
            student.setLastName(studentPatch.getLastName());
        }
        if (studentPatch.getEmail() != null) {
            student.setEmail(studentPatch.getEmail());
        }

        if (studentPatch.getCourses() != null) {

            for (Course c : studentPatch.getCourses()) {
                if ((courseRepository.findByTitle(c.getTitle()) == null)) {
                    courseRepository.save(c);
                }
            }
            student.setCourses(studentPatch.getCourses());
        }

        return studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

}
