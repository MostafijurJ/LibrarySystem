/*
  Author: Mostafijur Rahman
  Date: 11/11/2020
  Time: 5:10 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookCartController {

    @GetMapping("cart/{id}")
    public String cartedBook(){

        return "homePage";
    }
}
