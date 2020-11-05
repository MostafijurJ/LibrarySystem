package com.learn.springsecurity.service;


import com.learn.springsecurity.model.User;
import com.learn.springsecurity.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
