package com.springrest.springrest.controller;


import com.springrest.springrest.entity.Courses;
import com.springrest.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
  private  CourseService courseService;
    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }
    //GET THE COURSES
@GetMapping("/courses")
    public List<Courses> getCourses(){
return this.courseService.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public  Courses getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }
    @PostMapping("/courses" )
    public Courses addCourse(@RequestBody Courses course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses/{courseId}")
    public Courses updateCourse(@RequestBody Courses course,@PathVariable String courseId){
        return this.courseService.updateCourse(Long.parseLong(courseId),course);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try {
            this.courseService.deleteCourse(Long.parseLong((courseId)));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
