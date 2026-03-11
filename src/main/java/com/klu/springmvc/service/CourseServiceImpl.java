package com.klu.springmvc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.klu.springmvc.entity.Course;
import com.klu.springmvc.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repo;

    public CourseServiceImpl(CourseRepository repo) {
        this.repo = repo;
    }

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        return repo.findById(id).map(c -> {
            c.setTitle(course.getTitle());
            c.setDuration(course.getDuration());
            c.setFee(course.getFee());
            return repo.save(c);
        }).orElse(null);
    }

    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }

    public Course getCourse(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleContainingIgnoreCase(title);
    }
}