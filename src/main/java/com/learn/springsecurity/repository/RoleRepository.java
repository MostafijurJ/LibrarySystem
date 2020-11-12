/*
  Author: Mostafijur Rahman
  Date: 11/12/2020
  Time: 2:51 PM
*/


package com.learn.springsecurity.repository;

import com.learn.springsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);
}
