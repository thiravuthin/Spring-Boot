package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String test() {
        return "home";
    }

    @GetMapping("/user")
    public String user() {
        return "User Account Data!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin Account Data!";
    }
}