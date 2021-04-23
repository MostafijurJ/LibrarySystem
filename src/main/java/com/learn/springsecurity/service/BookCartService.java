package com.learn.springsecurity.service;

import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.entities.Role;
import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.BookRepository;
import com.learn.springsecurity.repository.RoleRepository;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookCartService {

  private final BookRepository bookRepository;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  public BookCartService(BookRepository bookRepository, UserRepository userRepository, RoleRepository roleRepository) {
    this.bookRepository = bookRepository;
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
  }

  public void addToCart(Long id, Principal principal) {
    String userName = principal.getName();
    User user = userRepository.findByUsername(userName);
    Book book = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
    List<User> userList = new ArrayList<>();
    userList.add(user);
    book.setUsers(userList);
    bookRepository.save(book);
  }

  public String roleCheck(Principal principal) {
    User user = userRepository.findByUsername(principal.getName());
    Role role = roleRepository.findById(user.getId())
        .orElseThrow(() -> new IllegalArgumentException("Invalid User Id:"));
    return role.getName();
  }

  public List<Book> findCartedBook(Principal principal) {
    User user = userRepository.findByUsername(principal.getName());
    List<Book> books = user.getBooks();
    return books;
  }


}
