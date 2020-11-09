/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 5:50 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.model.Book;
import com.learn.springsecurity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/saveUpdatebook/{id}")
public class UpdateBookController {

    @Autowired
    private BookRepository bookRepository;

    @ModelAttribute("book")
    public Book bookUpdated() {
        return new Book();
    }

    @GetMapping
    public String showBookForm() {
        return "updateBook";
    }

    @PostMapping
    public String updateInfo(@ModelAttribute Book book) {
        // bookRepository.save(book);

        System.out.println(book.getId());

        return "redirect:/saveUpdatebook?success";
    }
}
