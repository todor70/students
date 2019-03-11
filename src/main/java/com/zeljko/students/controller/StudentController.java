package com.zeljko.students.controller;

import com.zeljko.students.entity.Student;
import com.zeljko.students.exception.StudentNotFoundException;
import com.zeljko.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> list(){
        return studentService.list();
    }

    @PostMapping("/")
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student read(@PathVariable long id){

        if ( (id >= studentService.list().size()) || (id < 0) ) {
            throw new StudentNotFoundException("Student with id = " + id + " not found");
        }

        return studentService.read(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable long id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @PatchMapping("/{id}")
    public Student patch(@PathVariable long id, @RequestBody Student student){
        return studentService.patch(id, student);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){

        studentService.delete(id);

        return "Deleted student with id = " + id;
    }

}
