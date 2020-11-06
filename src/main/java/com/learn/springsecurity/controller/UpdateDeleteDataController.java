/*
  Author: Mostafijur Rahman
  Date: 11/6/2020
  Time: 6:02 PM
*/


package com.learn.springsecurity.controller;

import com.learn.springsecurity.model.UpdateInfo;
import com.learn.springsecurity.model.User;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateDeleteDataController {

    @Autowired
    UserRepository repository;

    //call to action when press edit/update information
    @GetMapping("update/{id}")
    public ModelAndView updateInfo(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView();
        User user = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        modelAndView.addObject("user", user);
        modelAndView.setViewName("update");
        return modelAndView;
    }

    // call to action when press save data
    @PostMapping(value = "save")
    public String saveUpdate(User user, @RequestParam("id") String id, @RequestParam("username") String name) {
        System.out.println(user.getName() + user.getId() + user.getPassword()+ user.getAddress());
        System.out.println(id+name);
        repository.save(user);
        return "success";
    }

    //delete controller
    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User student = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        repository.delete(student);
        return "login";
    }
}