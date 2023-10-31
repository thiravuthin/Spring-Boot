package com.example.springboot.feature.auth.service;

import com.example.springboot.feature.auth.payload.AuthRequest;
import com.example.springboot.feature.auth.payload.SignupRequest;

public interface AuthService {

    void signup( SignupRequest payload ) throws Throwable;

    void login( AuthRequest payload );
}