/*
  Author: Mostafijur Rahman
  Date: 11/12/2020
  Time: 1:19 PM
*/


package com.learn.springsecurity.service;

import com.learn.springsecurity.dto.BookRegisterDto;
import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.entities.Role;
import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.BookRepository;
import com.learn.springsecurity.repository.RoleRepository;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookCartService {

    @Autowired
    private  BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void addToCart(Long id, Principal principal){
        String userName = principal.getName();
        User user = userRepository.findByUsername(userName);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
        List<User> userList = new ArrayList<>();
        userList.add(user);
        book.setUsers(userList);
        bookRepository.save(book);
    }

    public String roleCheck(Principal principal){
        User user = userRepository.findByUsername(principal.getName());
        Role role = roleRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:"));
        return role.getName();
    }

}
