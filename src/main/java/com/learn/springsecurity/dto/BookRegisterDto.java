/*
  Author: Mostafijur Rahman
  Date: 11/11/2020
  Time: 10:02 AM
*/


package com.learn.springsecurity.dto;

public class BookRegisterDto {
    private String bookName;
    private  String authorName;
    private String version;
    private String date;

    private Long userId;

    public BookRegisterDto(){
        super();
    }

    public BookRegisterDto(String bookName, String authorName, String version, String date, Long userId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.version = version;
        this.date = date;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
