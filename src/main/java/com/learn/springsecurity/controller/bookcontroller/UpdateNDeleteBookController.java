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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class UpdateNDeleteBookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/updateBook/{id}")
    public String showBookForm(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("saveUpdatebook/{id}/{date}")
    public String updateBookInfo(Book book) {
        bookRepository.save(book);
        return "success";
    }

    @GetMapping("deleteBook/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
        return "deleteSuccessMessage";
    }
}
