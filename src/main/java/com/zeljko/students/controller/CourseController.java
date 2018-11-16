package com.zeljko.students.controller;

import com.zeljko.students.entity.Course;
import com.zeljko.students.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public Iterable<Course> list(){
        return courseService.list();
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Course create(@RequestBody Course course){
        return courseService.create(course);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public Course read(@PathVariable(value="id") long id){
        return courseService.read(id);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    public Course update(@PathVariable(value="id") long id, @RequestBody Course course){
        return courseService.update(id, course);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PATCH )
    public Course patch(@PathVariable(value="id") long id, @RequestBody Course course){
        return courseService.patch(id, course);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    public void delete(@PathVariable(value="id") long id){
        courseService.delete(id);
    }

}
