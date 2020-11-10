/*
  Author: Mostafijur Rahman
  Date: 11/6/2020
  Time: 6:03 PM
*/


package com.learn.springsecurity.controller;

import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ShowUserController {

    @Autowired
    UserRepository repository;

    @GetMapping("details")
    public String detailsShow(Model model, Principal principal) {
        String username = principal.getName();
        User user = repository.findByUsername(username);
        model.addAttribute("data", user);
        model.addAttribute("details", "details");

        return "index";
    }

    // Call to action when want to hide the details info
    @GetMapping("hide")
    public String hideDetails(Model model, Principal principal) {
        String username = principal.getName();
        User user = repository.findByUsername(username);
        model.addAttribute("data", user);
        model.addAttribute("details", "hide");

        return "index";
    }
}
