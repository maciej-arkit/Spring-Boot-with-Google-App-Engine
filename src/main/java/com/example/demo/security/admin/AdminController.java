package com.example.demo.security.admin;

import com.example.demo.security.models.User;
import com.example.demo.security.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/user/new")
    public String addUser(@RequestBody User user) {
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        userRepository.save(user);
        return "User added successfully";
    }

    @GetMapping("/test")
    public String test() {
        return "Test: OK";
    }
}
