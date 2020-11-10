/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 2:09 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.model.Book;
import com.learn.springsecurity.model.User;
import com.learn.springsecurity.repository.BookRepository;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/addBook")
public class BookRegisterController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("book")
    public Book bookRegister() {
        return new Book();
    }

    @GetMapping
    public String showBookForm() {
        return "addBook";
    }

    @PostMapping
    public String saveBook(@ModelAttribute Book book, Principal principal) {
        String userName = principal.getName();
        User user = userRepository.findByUsername(userName);
        Long userId = user.getId();
        book.setUserId(userId);
        bookRepository.save(book);
        return "redirect:/addBook?success";
    }
}
