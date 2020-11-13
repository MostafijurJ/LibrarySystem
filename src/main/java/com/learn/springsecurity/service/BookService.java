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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

    //Service for book registry controller
    public void saveBook(BookRegisterDto bookRegisterDto, Principal principal) {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String currentDate = dateFormat.format(date);
        bookRegisterDto.setDate(currentDate);

        User user = userRepository.findByUsername(principal.getName());
        bookRegisterDto.setUserId(user.getId());
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
        book.setUserId(user.getId());
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }
}
