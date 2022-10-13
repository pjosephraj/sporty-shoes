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

   @RequestMapping(value = "/products", method = RequestMethod.GET)
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

   @RequestMapping(value = "/add-product", method = RequestMethod.POST)
   public ModelAndView saveProduct(@ModelAttribute(name="productForm") Product product, Model model ) {

      productControllers.createProduct(product);
      ModelAndView mnv = new ModelAndView("product-list");
      List<Product> products = productControllers.getProducts();
      //      List<Product> noProducts = new ArrayList<>();
      mnv.addObject("products", products);
      mnv.addObject("success", true);
      mnv.addObject("message", "Products Successfully added.");
      mnv.addObject("isAdmin", true);
      return mnv;
   }

   @RequestMapping(value="/delete-product", method=RequestMethod.POST)
   public RedirectView deleteProduct(@ModelAttribute(name="productForm") Product product, RedirectAttributes ra) {
      System.out.println(product);
      productControllers.deleteProduct(product.getId());
      return listProducts(true, "Product Deleted Successfully!", ra);
   }

   public RedirectView listProducts(boolean isSuccess, String message, RedirectAttributes ra) {
      RedirectView rv = new RedirectView("/products", true);
      ra.addFlashAttribute("success", isSuccess);
      ra.addFlashAttribute("message", message);
      return rv;
   }
}
