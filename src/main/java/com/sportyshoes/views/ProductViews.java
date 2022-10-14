package com.sportyshoes.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.sportyshoes.controllers.ProductControllers;
import com.sportyshoes.entities.Product;

@Controller
public class ProductViews {

   @Autowired
   ProductControllers productControllers;

   @GetMapping(value = "/products")
   public ModelAndView productList() {
      ModelAndView mnv = new ModelAndView("product-list");
      List<Product> products = productControllers.getProducts();
      mnv.addObject("products", products);
      mnv.addObject("isAdmin", true);
      return mnv;
   }

   @GetMapping("/products/add")
   public String addProduct() {
      return "product-add";
   }

   @GetMapping("/products/{id}")
   public ModelAndView editProduct(@PathVariable("id") int id) {
      ModelAndView mnv = new ModelAndView("product-add");
      Product product = productControllers.getProduct(id);
      mnv.addObject("productId", product.getId());
      mnv.addObject("productName", product.getProduct_name());
      mnv.addObject("productBrand", product.getBrand());
      mnv.addObject("productColor", product.getColor());
      mnv.addObject("productPrice", product.getPrice());
      mnv.addObject("productSeason", product.getSeason());
      mnv.addObject("productCategory", product.getCategory());
      mnv.addObject("productDiscount", product.getDiscount());
      return mnv;
   }

   @PostMapping(value = "/add-product")
   public RedirectView saveProduct(@ModelAttribute(name="productForm") Product product, RedirectAttributes ra ) {
      productControllers.createProduct(product);
      return listProducts(true, "Product Added Successfully!", ra);
   }

   @PostMapping(value="/delete-product")
   public RedirectView deleteProduct(@ModelAttribute(name="productForm") Product product, RedirectAttributes ra) {
      productControllers.deleteProduct(product.getId());
      return listProducts(false, "Product Deleted Successfully!", ra);
   }

   public RedirectView listProducts(boolean isSuccess, String message, RedirectAttributes ra) {
      RedirectView rv = new RedirectView("/products", true);
      ra.addFlashAttribute("success", isSuccess);
      ra.addFlashAttribute("message", message);
      return rv;
   }
}
