package com.example.demo.controller;

import com.example.demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student-api")
public class StudentController {

        List<Student> students=new ArrayList<>(
                List.of(
                        new Student(1,"Wali","Java"),
                        new Student(2,"Ali","QA")
                ));

        @RequestMapping("getAllStudents")
        public List<Student> getAllStudents(){
                return students;
        }

        @PostMapping("addStudent")
        public String addStudent(@RequestBody Student student){
                students.add(student);
                return "Success";
        }

        @GetMapping("csrf-token")
        public CsrfToken getCsrfToken(HttpServletRequest request){
                System.out.println("request.getSession().getId(); "+request.getSession().getId());
                return (CsrfToken) request.getAttribute("_csrf");
        }

}
