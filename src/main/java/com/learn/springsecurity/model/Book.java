/*
  Author: Mostafijur Rahman
  Date: 11/9/2020
  Time: 1:55 PM
*/


package com.learn.springsecurity.model;

import com.sun.source.tree.LambdaExpressionTree;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Book{

    @Id
    @GeneratedValue
    private  Long id;
    private String bookName;
    private  String authorName;
    private String version;
    private String date;

    public Book(){
        super();
    }


    public Book(String bookName, String authorName, String version, String date) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.version = version;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
