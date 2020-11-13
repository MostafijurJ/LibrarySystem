/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 5:50 PM
*/


package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping()
public class BookOperationController {

    @Autowired
    private BookService bookService;

    @GetMapping("/updateBook/{id}")
    public String showBookForm(@PathVariable("id") long id, Model model) {
        Book book = bookService.loadBookByID(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("saveUpdatebook/{id}/{date}")
    public String updateBookInfo(Book book, Principal principal) {
        bookService.saveUpdateBook(book, principal);
        return "saveUpdateMessage";
    }

    @GetMapping("deleteBook/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return "deleteSuccessMessage";
    }
}
