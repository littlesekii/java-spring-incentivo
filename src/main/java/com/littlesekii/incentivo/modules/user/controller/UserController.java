package com.littlesekii.incentivo.modules.user.controller;

import com.littlesekii.incentivo.modules.user.entity.User;
import com.littlesekii.incentivo.modules.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var res = service.findById(id);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User res = service.save(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(res.getId()).toUri();

        return ResponseEntity.created(uri).body(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User res = service.update(id, user);

        return ResponseEntity.ok().body(res);
    }
}
