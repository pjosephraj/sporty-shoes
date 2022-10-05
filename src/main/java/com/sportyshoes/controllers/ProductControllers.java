package com.sportyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

   @RequestMapping(value = "", method = RequestMethod.GET)
   public List<Product> getProducts() {
      return repository.findAll();
   }

   @RequestMapping(value = "{id}", method = RequestMethod.GET)
   public Product getProduct(@PathVariable("id") int id) {
      return repository.findById(id).get();
   }

   @RequestMapping(value = "", method = RequestMethod.POST)
   public Product createProduct(@RequestBody Product product) {
      return repository.save(product);
   }

   @RequestMapping(value = "", method = RequestMethod.PUT)
   public Product updateProduct(Product product) {
      return repository.save(product);
   }

   @RequestMapping("{id}")
   public void deleteProduct(@PathVariable("id") int id) {
      repository.deleteById(id);
   }

}
