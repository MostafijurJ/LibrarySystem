/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 3:35 PM
*/


package com.learn.springsecurity.repository;

import com.learn.springsecurity.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends CrudRepository<Book, Long> {
}
