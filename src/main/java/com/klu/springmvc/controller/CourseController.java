package com.klu.springmvc.controller;

import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klu.springmvc.entity.Course;
import com.klu.springmvc.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(service.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Course course = service.getCourse(id);
        if (course == null)
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);
        if (updated == null)
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}