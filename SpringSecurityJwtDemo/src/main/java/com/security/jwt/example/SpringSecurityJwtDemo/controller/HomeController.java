package com.security.jwt.example.SpringSecurityJwtDemo.controller;

import com.security.jwt.example.SpringSecurityJwtDemo.models.Users;
import com.security.jwt.example.SpringSecurityJwtDemo.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<Users> getUser(){
        System.out.println("getting users");
        return this.userService.getUsers();
    }



}
