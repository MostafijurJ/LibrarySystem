package com.learn.springsecurity.controller.usercontroller;


import com.learn.springsecurity.dto.UserRegistrationDto;
import com.learn.springsecurity.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.ResultSet;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(@ModelAttribute("userRegistrationDto")UserRegistrationDto userRegistrationDto) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("userRegistrationDto")  UserRegistrationDto userRegistrationDto, BindingResult result, Model model) {
        System.out.println(userRegistrationDto);
        model.addAttribute("data", userRegistrationDto);
        if(result.hasErrors()){
            System.out.println("error found");
            return "registration";
        }


       // userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
