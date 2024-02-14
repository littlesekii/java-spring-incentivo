package com.littlesekii.incentivo.modules.product.repository;

import com.littlesekii.incentivo.modules.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
