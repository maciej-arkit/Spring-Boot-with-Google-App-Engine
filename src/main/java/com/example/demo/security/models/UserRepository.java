package com.example.demo.security.models;

import com.example.demo.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUsername(String username);

}
