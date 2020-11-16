package com.learn.springsecurity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

    @NotBlank
    private String name;
    @Size(min = 3, max = 10, message = "username must be 3 to 10 character")
    private String username;
    @Email(message = "Email is not Valid")
    private String email;
    @Size(min = 9, max = 11, message = "phone number must be 11 digit")
    private String phone;
    private String address;
    private String password;


    public UserRegistrationDto(String name, String username, String email, String phone, String address, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
