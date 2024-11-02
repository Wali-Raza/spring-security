package com.jwtdemo.spring_security.controller;

import com.jwtdemo.spring_security.config.SecurityConfig;
import com.jwtdemo.spring_security.model.Token;
import com.jwtdemo.spring_security.model.User;
import com.jwtdemo.spring_security.service.JwtService;
import com.jwtdemo.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("register")
    public User registerUser(@RequestBody User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        System.out.println("user : " + user);
        return userService.registerUser(user);
    }

    @PostMapping("login")
    public Token login(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            Token token=new Token();
            token.setAccess_token(jwtService.generateToken(user.getUsername()));
//            String access_token=
            return token;
        }
//
        return null;
    }
}
