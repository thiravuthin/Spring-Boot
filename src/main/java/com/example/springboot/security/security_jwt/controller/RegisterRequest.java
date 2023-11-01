package com.example.springboot.security.security_jwt.controller;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String Lastname;
    private String email;
    private String password;

}