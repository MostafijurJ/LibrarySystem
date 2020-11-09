/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 1:25 PM
*/

package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.model.Book;
import com.learn.springsecurity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/home")
    public String homePage() {
        return "homepage";
    }


    @GetMapping("/viewBook")
    public String ViewBook(Model model){
        Collection<Book> books = (Collection<Book>) bookRepository.findAll();
        model.addAttribute("books", books);

        return "viewBook";
    }

    @GetMapping("/details/{id}")
    public String detailsShow(@PathVariable("id") Long id, Model model){

        Book book = bookRepository.findById(id)
                . orElseThrow(() -> new IllegalArgumentException("Invalid Book Id:" + id));

        model.addAttribute("book", book);
        return "bookdetailsShow";
    }





}
