package com.learn.springsecurity;

import com.learn.springsecurity.entities.Book;
import com.learn.springsecurity.entities.User;
import com.learn.springsecurity.repository.BookRepository;
import com.learn.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ProfileManagementApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProfileManagementApplication.class, args);

	}


}
