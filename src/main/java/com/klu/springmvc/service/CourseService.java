package com.klu.springmvc.service;

import java.util.List;
import com.klu.springmvc.entity.Course;

public interface CourseService {
    Course addCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    Course getCourse(Long id);
    List<Course> getAllCourses();
    List<Course> searchByTitle(String title);
}