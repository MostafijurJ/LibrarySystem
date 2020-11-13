/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 2:09 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.dto.BookRegisterDto;
import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/addBook")
public class BookRegisterController {

    @Autowired
    private BookService bookService;

    @ModelAttribute("book")
    public Book bookRegister() {
        return new Book();
    }

    @GetMapping
    public String showBookForm() {
        return "addBook";
    }

    @PostMapping
    public String saveBook(@ModelAttribute BookRegisterDto  bookRegisterDto, Principal principal) {

        bookService.saveBook(bookRegisterDto,principal);
        return "redirect:/addBook?success";
    }
}
