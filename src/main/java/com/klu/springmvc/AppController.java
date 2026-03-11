package com.klu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private StudentDao1 sdao;

    @GetMapping("/f1")
    public String test() {
        return "Welcome to Spring Boot Framework";
    }

    // localhost:8080/app/add/10/20
    @GetMapping("/add/{a}/{b}")
    public int add(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    // localhost:8080/app/sub?a=10&b=20
    @GetMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    // CREATE
    @PostMapping("/student")
    public Student insert(@RequestBody Student s) {
        return sdao.insert(s);
    }

    // READ ALL
    @GetMapping("/student")
    public List<Student> findAll() {
        return sdao.findAll();
    }

    // UPDATE
    @PutMapping("/student")
    public boolean update(@RequestBody Student s) {
        return sdao.update(s);
    }

    // DELETE
    @DeleteMapping("/student/{id}")
    public boolean delete(@PathVariable int id) {
        return sdao.delete(id);
    }

    // FIND BY NAME
    @GetMapping("/student/name/{name}")
    public Student getByName(@PathVariable String name) {
        return sdao.findByName(name);
    }

    // FIND BY NAME & CGPA
    @GetMapping("/student/combined/{name}/{cgpa}")
    public Student getByNameAndCgpa(@PathVariable String name,
                                    @PathVariable double cgpa) {
        return sdao.findByNameAndCgpa(name, cgpa);
    }

    // PAGINATION
    @GetMapping("/student/page/{page}/limit/{limit}")
    public Page<Student> getByPage(@PathVariable int page,
                                   @PathVariable int limit) {
        return sdao.findPage(page, limit);
    }

    // PATCH UPDATE
    @PatchMapping("/student/update/{name}/{cgpa}")
    public String updateCgpaByName(@PathVariable String name,
                                   @PathVariable double cgpa) {
        return sdao.updateCgpaByName(name, cgpa);
    }
}