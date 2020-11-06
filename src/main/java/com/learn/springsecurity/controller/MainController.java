package com.learn.springsecurity.controller;


import com.learn.springsecurity.model.UpdateInfo;
import com.learn.springsecurity.model.User;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

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

	@GetMapping("update/{id}")
	public ModelAndView updateInfo(@PathVariable("id") Long id){

		ModelAndView modelAndView = new ModelAndView();
		User user = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));;

		modelAndView.addObject("user",user);
		modelAndView.setViewName("update");
		return modelAndView;
	}

	@PostMapping(value = "save/{id}")
	public  String saveUpdate(@PathVariable("id") Long id, @ModelAttribute User user, BindingResult result) {

		if (result.hasErrors()) {
			user.setId(id);
			return "update";
		}
		System.out.println(user.getName());
		return "success";
	}

	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		User student = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		repository.delete(student);
		return "login";
	}

	@GetMapping("details")
		public String detailsShow(Model model, Principal principal) {
		String username = principal.getName();
		User user = repository.findByUsername(username);
		model.addAttribute("data",user);
		model.addAttribute("details","details");

		return "index";
		}

		@GetMapping("hide")
		public String hideDetails(Model model, Principal principal) {
		String username = principal.getName();
		User user = repository.findByUsername(username);
		model.addAttribute("data",user);
		model.addAttribute("details","hide");
		return "index";
		}



	/*@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
								Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "index";
	}*/
}
