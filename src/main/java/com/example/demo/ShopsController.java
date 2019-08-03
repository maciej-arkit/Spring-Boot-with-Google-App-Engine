package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShopsController {

    private final ShopRepository shopRepository;

    public ShopsController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "Spring Boot and Google App Engine - Hello World!";
    }

    @GetMapping("/shops")
    public List<Shop> getShops() {
        List<Shop> shopsList = new ArrayList<>();
        this.shopRepository.findAll().forEach(shopsList::add);
        return shopsList;
    }
}
