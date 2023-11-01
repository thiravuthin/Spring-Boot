package com.example.springboot.security.security_jwt.controller;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
  private String token;
}