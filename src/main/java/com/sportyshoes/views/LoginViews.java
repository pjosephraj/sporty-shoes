package com.sportyshoes.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sportyshoes.entities.Auth;

@Controller
public class LoginViews {

   @RequestMapping("/login")
   public String login() {
      return "login";
   }

   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public String authLogin(@ModelAttribute(name="loginForm") Auth loginForm) {
      String user_email = loginForm.getUser_email();
      return "j@r.com".equals(user_email) ? "redirect:/products" : "login";
   }


}
