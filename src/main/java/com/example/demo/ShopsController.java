package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopsController {

    private final ShopRepository shopRepository;

    public ShopsController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/shops")
    public String shops(Model model) {
        List<Shop> shopsList = new ArrayList<>();
        this.shopRepository.findAll().forEach(shopsList::add);
        model.addAttribute("shops", shopsList);
        return "shops";
    }
}
