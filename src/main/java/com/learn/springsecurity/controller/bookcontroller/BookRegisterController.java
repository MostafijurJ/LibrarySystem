/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 2:09 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.model.Book;
import com.learn.springsecurity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addBook")
public class BookRegisterController {

    @Autowired
    private BookRepository bookRepository;


    @ModelAttribute("book")
    public Book bookRegister() {
        return new Book();
    }

    @GetMapping
    public String showBookForm() {
        return "addBook";
    }

    @PostMapping
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/addBook?success";
    }
}
