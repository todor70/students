package com.zeljko.students.controller;

import com.zeljko.students.entity.Course;
import com.zeljko.students.exception.StudentNotFoundException;
import com.zeljko.students.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public List<Course> list(){
        return courseService.list();
    }

    @PostMapping("/")
    public Course create(@RequestBody Course course){
        return courseService.create(course);
    }

    @GetMapping("/{id}")
    public Course read(@PathVariable long id){

        if ( (id >= courseService.list().size()) || (id < 0) ) {
            throw new StudentNotFoundException("Course with id = " + id + " not found");
        }

        return courseService.read(id);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable long id, @RequestBody Course course){
        return courseService.update(id, course);
    }

    @PatchMapping("/{id}")
    public Course patch(@PathVariable long id, @RequestBody Course course){
        return courseService.patch(id, course);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){

        courseService.delete(id);

        return "Deleted course with id = " + id;
    }

}
