/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 3:35 PM
*/


package com.learn.springsecurity.repository;

import com.learn.springsecurity.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface BookRepository  extends CrudRepository<Book, Long> {

    Collection<Book> findAllByUserId(Long userId);
    String query = "select * from Book where id =:id";
/*    @Query(nativeQuery = true, value = query)
    List<String> findAllBy(@Param("id") long id);*/
}
