package com.learn.springsecurity.controller.usercontroller;


import com.learn.springsecurity.dto.UserRegistrationDto;
import com.learn.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
@Validated
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(@ModelAttribute("userRegistrationDto")UserRegistrationDto userRegistrationDto) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("userRegistrationDto")  UserRegistrationDto userRegistrationDto, BindingResult result) {
        System.out.println(userRegistrationDto);
        if(result.hasErrors()){
            System.out.println("error found");
            return "registration";
        }

       // userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
