package com.jwtdemo.spring_security.service;


import com.jwtdemo.spring_security.model.User;
import com.jwtdemo.spring_security.model.UserDetailsImpl;
import com.jwtdemo.spring_security.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    MyRepository myRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user=myRepository.findByusername(username);
        System.out.println("User from Db : "+user.toString());
         if(user ==null ){
             System.out.println("404 : user not found");
             return null;
         }
    return new UserDetailsImpl(user);

    }
}
