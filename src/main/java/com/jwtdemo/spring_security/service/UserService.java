package com.jwtdemo.spring_security.service;


import com.jwtdemo.spring_security.model.User;
import com.jwtdemo.spring_security.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    MyRepository myRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return myRepository.save(user);
    }
}
