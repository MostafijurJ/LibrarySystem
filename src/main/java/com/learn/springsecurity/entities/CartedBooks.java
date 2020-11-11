/*
  Author: Mostafijur Rahman
  Date: 11/11/2020
  Time: 5:20 PM
*/


package com.learn.springsecurity.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartedBooks {

    @Id
    @GeneratedValue
    private Long id;


}
