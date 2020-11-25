package com.learn.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ProfileManagementApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProfileManagementApplication.class, args);

	}


}
