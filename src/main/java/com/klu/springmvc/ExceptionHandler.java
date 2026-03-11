package com.klu.springmvc;


import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
       @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
       public String handler(RuntimeException ex) {
       return ex.getMessage();
}
}
