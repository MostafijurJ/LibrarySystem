package com.learn.springsecurity.repository;

import com.learn.springsecurity.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

  Collection<Book> findAllByUserId(Long userId);
}
