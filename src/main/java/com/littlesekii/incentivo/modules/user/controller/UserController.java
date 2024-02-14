package com.littlesekii.incentivo.modules.user.controller;

import com.littlesekii.incentivo.modules.user.entity.User;
import com.littlesekii.incentivo.modules.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var res = service.findById(id);
        return ResponseEntity.ok().body(res);
    }
}
