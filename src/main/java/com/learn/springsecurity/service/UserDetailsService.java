package com.learn.springsecurity.service;

import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findByID(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
    return user;
  }

  public User findByUserName(String userName) {
    User user = userRepository.findByUsername(userName);
    return user;
  }

  public void save(User user) {
    userRepository.save(user);
  }

  public void deleteUserByID(long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
    userRepository.delete(user);
  }
}
