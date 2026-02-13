package com.klu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private StudentDao sdao;

    @GetMapping("/f1")
    public String test() {
        return "Welcome to Spring Boot Framework";
    }

    // http://localhost:8081/app/add/10/20
    @GetMapping("/add/{a}/{b}")
    public int add(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    // http://localhost:8081/app/sub?a=10&b=20
    @GetMapping("/sub")
    public int sub(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    @PostMapping("/student")
    public boolean insert(@RequestBody Student s) {
        return sdao.insert(s);
    }

    @GetMapping("/student")
    public List<Student> findAll() {
        return sdao.findAll();
    }

    @PutMapping("/student")
    public boolean update(@RequestBody Student s) {
        return sdao.update(s);
    }

    @DeleteMapping("/student/{id}")
    public boolean delete(@PathVariable int id) {
        return sdao.delete(id);
    }
}