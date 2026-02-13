package com.klu.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    private List<String> books = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library";
    }

    @GetMapping("/count")
    public int count() {
        return 120;
    }

    @GetMapping("/price")
    public double price() {
        return 450.75;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java", "Spring Boot", "Microservices");
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book ID is: " + id;
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Author name is: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody String book) {
        books.add(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<String> viewBooks() {
        return books;
    }
}