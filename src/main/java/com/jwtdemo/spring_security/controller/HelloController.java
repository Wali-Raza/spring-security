package com.jwtdemo.spring_security.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("spring-securit")
public class HelloController {
    @RequestMapping("hello")
    public String hello(HttpServletRequest request){
        return "Hello world!!! "+request.getSession().getId();
    }
    @RequestMapping("about")
    public String about(HttpServletRequest request){
        return "Hello world!!! "+request.getSession().getId();
    }
}
