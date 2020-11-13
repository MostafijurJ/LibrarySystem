package com.learn.springsecurity.controller.usercontroller;


import com.learn.springsecurity.dto.UserRegistrationDto;
import com.learn.springsecurity.service.UserService;
import org.springframework.stereotype.Controller;
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

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("userRegistrationDto")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@Valid UserRegistrationDto userRegistrationDto, BindingResult result) {

        if(result.hasErrors()){
            System.out.println("error found");
            return "registration";
        }
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
