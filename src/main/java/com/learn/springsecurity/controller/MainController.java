package com.learn.springsecurity.controller;


import com.learn.springsecurity.model.User;
import com.learn.springsecurity.repository.UserRepository;
import com.learn.springsecurity.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.awt.event.MouseEvent;
import java.security.Principal;

@Controller
public class MainController {

	@Autowired
	UserRepository repository;
	
	@GetMapping("/login")
	public String login() {



		return "login";
	}
	
	@GetMapping("/")
	public ModelAndView home(Principal principal) {

		String username = principal.getName();
		ModelAndView  model = new ModelAndView();
		User user = repository.findByUsername(username);
		model.setViewName("index");
		model.addObject("data",user);
		return model;
	}

	@GetMapping("/update")
	public ModelAndView updateInfo(Principal principal){
		ModelAndView modelAndView = new ModelAndView();

		String username = principal.getName();
		ModelAndView  model = new ModelAndView();
		User user = repository.findByUsername(username);
		//System.out.println(user.getPassword()+ user.getName());
		model.addObject("user",user);
		modelAndView.setViewName("update");
		return modelAndView;
	}

	@GetMapping("/save")
	public  String saveUpdate(@ModelAttribute UserRegistrationDto userRegistrationDto){

		System.out.println(userRegistrationDto);

		return "Successfully update information";
	}
}
