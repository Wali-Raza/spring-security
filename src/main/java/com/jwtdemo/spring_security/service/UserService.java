package com.jwtdemo.spring_security.service;


import com.jwtdemo.spring_security.model.User;
import com.jwtdemo.spring_security.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    MyRepository myRepository;
    public User registerUser(User user) {
        return myRepository.save(user);
    }
}
