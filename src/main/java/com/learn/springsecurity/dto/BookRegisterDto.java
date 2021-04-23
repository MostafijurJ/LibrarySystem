package com.learn.springsecurity.dto;

public class BookRegisterDto {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }


    public String getVersion() {
        return version;
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
