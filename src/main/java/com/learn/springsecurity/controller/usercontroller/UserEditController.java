/*
  Author: Mostafijur Rahman
  Date: 11/6/2020
  Time: 6:02 PM
*/


package com.learn.springsecurity.controller.usercontroller;

import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserEditController {

    @Autowired
    UserDetailsService userDetailsService;

    //call to action when press edit/update information
    @GetMapping("update/{id}")
    public ModelAndView updateInfo(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userDetailsService.findByID(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("updateUser");
        return modelAndView;
    }

    // call to action when press save data
    @PostMapping("save/{id}/{username}")
    public String saveUpdate(User user) {
        userDetailsService.save(user);
        return "saveUpdateMessage";
    }

    //delete controller
    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userDetailsService.deleteUserByID(id);
        return "login";
    }
}
