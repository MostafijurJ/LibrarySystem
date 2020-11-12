/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 1:25 PM
*/

package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String homePage(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("allBook", bookList);
        return "allBookList";
    }

    @GetMapping("/viewBook")
    public String ViewBook(Model model, Principal principal) {
        List<Book> books = bookService.findAllBook(principal);
        model.addAttribute("books", books);
        return "viewBook";
    }

    //Controller for unique book details view
    @GetMapping("/details/{id}")
    public String detailsShow(@PathVariable("id") Long id, Model model) {
        Book book = bookService.loadBookByID(id);
        model.addAttribute("book", book);
        return "bookDetailsShow";
    }


}
