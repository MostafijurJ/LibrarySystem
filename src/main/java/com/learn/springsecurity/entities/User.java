package com.learn.springsecurity.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "username", name = "uniqueNameConstraint")}
)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @NotBlank
  @Size(min = 3, max = 10)
  private String username;
  @Email
  private String email;
  private String phone;
  private String address;
  private String password;

  @ManyToMany(mappedBy = "users")
  private List<Book> books;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Role> roles;

  public User(String userName, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {

  }

  public User() {
    super();
  }


  public User(String name, String username, String email, String phone, String address, String password, Collection<Role> roles) {
    this.name = name;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.password = password;
    this.roles = roles;
  }


  public User(String name, String email, String phone, String address, String password) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.password = password;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public String getUserName() {
    return username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setUserName(String userName) {
    this.username = userName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Collection<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }

}