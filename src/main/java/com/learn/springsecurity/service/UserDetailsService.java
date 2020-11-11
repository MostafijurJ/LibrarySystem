/*
  Author: Mostafijur Rahman
  Date: 11/11/2020
  Time: 12:12 PM
*/


package com.learn.springsecurity.service;

import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    UserRepository userRepository;

    //Service for Update user form controller
    public User findByID(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        return user;
    }

    public User findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        return user;
    }

    //Service for save update user controller
    public void save(User user) {
        userRepository.save(user);
    }

    //Service for save delete user controller
    public void deleteUserByID(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        userRepository.delete(user);
    }
}
