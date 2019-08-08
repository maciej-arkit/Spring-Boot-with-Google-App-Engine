package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopsController {

    @GetMapping("/")
    public String hello() {
        return "Spring Boot and Google App Engine - Hello World!";
    }
}
