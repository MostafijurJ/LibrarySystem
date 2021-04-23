package com.learn.springsecurity.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Book{

    @Id
    @GeneratedValue
    private  Long id;
    @NotBlank
    private String bookName;
    @NotBlank
    private  String authorName;
    @Column
    private String version;
    @Column
    private String date;
   @Column(name = "admin_id")
    private Long  userId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> users;

    public Book(){
        super();
    }

    public Book(String bookName, String authorName, String version, String date, Long userId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.version = version;
        this.date = date;
        this.userId = userId;
    }

    public Book(Long id, String bookName, String authorName, String version, String date, Long  userId) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.version = version;
        this.date = date;
        this.userId = userId;
    }

    public Book(String bookName, String authorName, String version, String date, Long userId, List<User> users) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.version = version;
        this.date = date;
        this.userId = userId;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
