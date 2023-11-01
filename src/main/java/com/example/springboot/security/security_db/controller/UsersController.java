package com.example.springboot.security.security_db.controller;

import com.example.springboot.security.security_db.domain.UserDB;
import com.example.springboot.security.security_db.repository.UserDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UsersController {

   private final UserDBRepository userDBRepository;
    @GetMapping("/")
    public String homePage(){
        return "Hello world";
    }
    @GetMapping("/users")
    public String user(){
        return "Hello world";
    }
    @GetMapping("/admins")
    public String admin(){
        return "Hello world";
    }


}