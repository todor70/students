package com.zeljko.students.controller;

import com.zeljko.students.entity.Student;
import com.zeljko.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Student> list(){
        return studentService.list();
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public Student read(@PathVariable(value="id") long id){
        return studentService.read(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    public Student update(@PathVariable(value="id") long id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PATCH )
    public Student patch(@PathVariable(value="id") long id, @RequestBody Student student){
        return studentService.patch(id, student);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") long id){
        studentService.delete(id);
    }

}
