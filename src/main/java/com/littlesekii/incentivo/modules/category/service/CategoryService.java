package com.littlesekii.incentivo.modules.category.service;

import com.littlesekii.incentivo.modules.category.entity.Category;
import com.littlesekii.incentivo.modules.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id).get();
    }
    
    
}
