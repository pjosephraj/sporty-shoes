package com.sportyshoes.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entities.Product;

@RestController
public interface ProductRepository extends JpaRepository<Product, Integer> {
}