package com.learn.springsecurity.controller;


import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MainUserController {

  private final UserRepository repository;

  public MainUserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public ModelAndView home(Principal principal) {
    String username = principal.getName();
    ModelAndView model = new ModelAndView();
    User user = repository.findByUsername(username);
    model.setViewName("index");
    model.addObject("data", user);
    return model;
  }


}
