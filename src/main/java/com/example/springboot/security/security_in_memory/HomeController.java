package com.example.springboot.security.security_in_memory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
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