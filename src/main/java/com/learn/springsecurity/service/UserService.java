package com.learn.springsecurity.service;


import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  User save(UserRegistrationDto registrationDto);
}
