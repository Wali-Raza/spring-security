package com.jwtdemo.spring_security.repository;

import com.jwtdemo.spring_security.model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories
public interface MyRepository extends JpaRepository<User,String> {

    User findByusername(String username);
}
