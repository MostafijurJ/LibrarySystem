package com.learn.springsecurity.controller.usercontroller;

import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.service.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserEditController {

  private final UserDetailsService userDetailsService;

  public UserEditController(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @GetMapping("update/{id}")
  public ModelAndView updateInfo(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView();
    User user = userDetailsService.findByID(id);
    modelAndView.addObject("user", user);
    modelAndView.setViewName("updateUser");
    return modelAndView;
  }

  @PostMapping("save/{id}/{username}")
  public String saveUpdate(User user) {
    userDetailsService.save(user);
    return "saveUpdateMessage";
  }

  @GetMapping("delete/{id}")
  public String deleteUser(@PathVariable("id") long id) {
    userDetailsService.deleteUserByID(id);
    return "login";
  }
}
