package com.klu.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")   // base path to avoid conflicts
public class SampleController {

    @GetMapping("/test")
    public String testApi() {
        return "SampleController is working!";
    }
}