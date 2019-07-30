package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class DemoApplication {
	private final JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public DemoApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@GetMapping("/")
	public String hello() {
		return "Spring Boot and Google App Engine - Hello World!";
	}

	@GetMapping("/shops")
	public List<String> getShops() {
		return this.jdbcTemplate.queryForList("SELECT * FROM shops").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
}
