package com.springrest.springrest.service;

import com.springrest.springrest.entity.Courses;


import java.util.List;

public interface CourseService {
    public List<Courses> getCourses();

    public Courses getCourse(Long courseId);

    public Courses addCourse(Courses course);

    public Courses updateCourse(Long courseId, Courses updatedCourse);

    public void deleteCourse(Long courseId);
}
