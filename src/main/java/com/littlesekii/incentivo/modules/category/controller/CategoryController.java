package com.littlesekii.incentivo.modules.category.controller;

import com.littlesekii.incentivo.modules.category.entity.Category;
import com.littlesekii.incentivo.modules.category.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        var res = service.findById(id);
        return ResponseEntity.ok().body(res);
    }
}
