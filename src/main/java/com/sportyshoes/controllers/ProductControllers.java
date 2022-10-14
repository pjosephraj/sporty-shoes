package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entities.Product;
import com.sportyshoes.repos.ProductRepository;

@RestController
@RequestMapping("/api/products/")
public class ProductControllers {

   @Autowired
   ProductRepository repository;

   @GetMapping(value = "")
   public List<Product> getProducts() {
      return repository.findAll();
   }

   @GetMapping(value = "{id}")
   public Product getProduct(@PathVariable("id") int id) {
      return repository.findById(id).get();
   }

   @PostMapping(value = "")
   public Product createProduct(@RequestBody Product product) {
      return repository.save(product);
   }

   @PutMapping(value = "")
   public Product updateProduct(Product product) {
      return repository.save(product);
   }

   @DeleteMapping("{id}")
   public void deleteProduct(@PathVariable("id") int id) {
      repository.deleteById(id);
   }

//   @GetMapping(value="create-table")
//   public void createTable() {
//
//   }

}
