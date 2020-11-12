/*
  Author: Mostafijur Rahman
  Date: 11/11/2020
  Time: 5:10 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.dto.BookRegisterDto;
import com.learn.springsecurity.service.BookCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class BookCartController {

    @Autowired
    private BookCartService bookCartService;

    @GetMapping("cart/{id}")
    public String cartedBook(@PathVariable("id") Long id, Principal principal, Model model){
            bookCartService.addToCart(id ,principal);
            String userRole = bookCartService.roleCheck(principal);
            model.addAttribute("userRole", userRole);
        return "homePage";
    }
}
