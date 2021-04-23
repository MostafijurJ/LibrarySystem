package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.service.BookCartService;
import com.learn.springsecurity.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class BookController {

  private final BookService bookService;
  private final BookCartService bookCartService;

  public BookController(BookService bookService, BookCartService bookCartService) {
    this.bookService = bookService;
    this.bookCartService = bookCartService;
  }

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

  @GetMapping("/details/{id}")
  public String detailsShow(@PathVariable("id") Long id, Model model, Principal principal) {
    Book book = bookService.loadBookByID(id);
    model.addAttribute("userRole", bookCartService.roleCheck(principal));
    model.addAttribute("book", book);
    return "bookDetailsShow";
  }


}
