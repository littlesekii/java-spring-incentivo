package com.littlesekii.incentivo.modules.user.controller;

import com.littlesekii.incentivo.modules.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = List.of(new User(1L, "Davi Bacalhau", "littlesekii@gmail.com", "(21) 94002-8922", "uvekp23465"));
        return ResponseEntity.ok().body(users);
    }
}
