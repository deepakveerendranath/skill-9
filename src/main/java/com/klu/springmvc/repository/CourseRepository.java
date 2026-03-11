package com.klu.springmvc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.springmvc.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTitleContainingIgnoreCase(String title);
}