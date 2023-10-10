package com.springrest.springrest.service;

import com.springrest.springrest.entity.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{

    List<Courses> list;

    public CourseServiceImpl() {
        list=new ArrayList<>();
        list.add(new Courses(145,"Java Core Course","this course contains basics of java"));
        list.add(new Courses(146,"Spring boot Course","creating rest api using springboot"));

    }

    @Override
    public List<Courses> getCourses() {
        return list;
    }

    @Override
    public Courses getCourse(Long courseId) {
        Courses c=null;
        for(Courses course:list){
            if(course.getId()==courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Courses addCourse(Courses course) {
        list.add(course);
        return course;
    }
    @Override
    public Courses updateCourse(Long courseId, Courses updatedCourse) {
        for (Courses course : list) {
            if (course.getId() == courseId) {
                course.setTitle(updatedCourse.getTitle());
                course.setDescription(updatedCourse.getDescription());
                // You can update other properties as needed

                return course; // Return the updated course
            }
        }
        return null; // Return null if the course with the specified ID is not found
    }

    @Override
    public void deleteCourse(Long courseId) {
        list.forEach(course -> {
            if (course.getId() == courseId) {
                list.remove(course); // Remove the course from the list
                // Exit the forEach loop after removal
            }
        });
    }


}
