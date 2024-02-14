package com.littlesekii.incentivo.modules.product.service;

import com.littlesekii.incentivo.modules.product.entity.Product;
import com.littlesekii.incentivo.modules.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).get();
    }
}
