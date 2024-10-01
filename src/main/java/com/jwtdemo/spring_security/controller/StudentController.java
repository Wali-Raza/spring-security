package com.jwtdemo.spring_security.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    List<Student> students=new ArrayList<>(Arrays.asList(
            new Student(1,"wali","java"),
            new Student(2,"Ali","java")
    ));
    @GetMapping("getStundets")
    public List<Student> getStudents(HttpServletRequest request){
        return students;
    }

    @PostMapping("addStudent")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "added Successfully";
    }
    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        System.out.println("request.getSession().getId(); "+request.getSession().getId());
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
