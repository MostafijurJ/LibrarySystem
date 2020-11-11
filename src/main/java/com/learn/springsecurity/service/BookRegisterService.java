/*
  Author: Mostafijur Rahman
  Date: 11/11/2020
  Time: 10:04 AM
*/

package com.learn.springsecurity.service;

import com.learn.springsecurity.dto.BookRegisterDto;
import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.BookRepository;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class BookRegisterService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    //Service for book registry controller
    public void saveBook(BookRegisterDto bookRegisterDto, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Long userId = user.getId();
        bookRegisterDto.setUserId(userId);

        Book book = new Book(bookRegisterDto.getBookName(), bookRegisterDto.getAuthorName(),
                bookRegisterDto.getVersion(), bookRegisterDto.getDate(), bookRegisterDto.getUserId());
        bookRepository.save(book);
    }

    //Service for list view of  all the books
    public List<Book> findAllBook(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        List<Book> books = (List<Book>) bookRepository.findAllByUserId(user.getId());
        return books;
    }

    //Service for book details show controller
    public Book loadBookByID(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Book Id:" + id));

        return book;
    }

    //Service for updating book controller
    public void saveUpdateBook(Book book, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Long userId = user.getId();
        book.setUserId(userId);
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
