package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShopsController {

    private final JdbcTemplate jdbcTemplate;

    public ShopsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/")
    public String hello() {
        return "Spring Boot and Google App Engine - Hello World!";
    }

    @GetMapping("/test")
    public String getShops() {
        String currentTimestamp = jdbcTemplate.queryForObject("SELECT CURRENT_TIMESTAMP()", String.class);
        return "CURRENT TIMESTAMP: " + currentTimestamp;
    }
}
