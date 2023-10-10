package com.example.springboot.auth.service;

import com.example.springboot.auth.payload.SignupRequest;

public interface AuthService {

    Object signUp(SignupRequest payload);
}