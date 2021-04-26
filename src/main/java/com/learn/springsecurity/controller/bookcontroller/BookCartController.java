package com.learn.springsecurity.controller.bookcontroller;

import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.service.BookCartService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BookCartController implements BookCartApi {

  private final BookCartService bookCartService;

  public BookCartController(BookCartService bookCartService) {
    this.bookCartService = bookCartService;
  }

  @GetMapping("cart/{id}")
  public String cartedBook(@PathVariable("id") Long id, Principal principal, Model model) {
    bookCartService.addToCart(id, principal);
    String userRole = bookCartService.roleCheck(principal);
    model.addAttribute("userRole", userRole);
    return "homePage";
  }

  @GetMapping("cart")
  public String cartedHomePage(Principal principal, Model model) {
    String userRole = bookCartService.roleCheck(principal);
    model.addAttribute("userRole", userRole);
    return "homePage";
  }

  @GetMapping("show-all")
  public String showAllCartedBook(Principal principal, Model model) {
    List<Book> book = bookCartService.findCartedBook(principal);
    model.addAttribute("listBook", book);
    return "cartedBookList";
  }
}
