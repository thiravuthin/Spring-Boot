package com.example.springboot.auth.service;

import com.example.springboot.auth.payload.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    //@Transactional /* save */
    @Override
    public Object signUp(SignupRequest payload) {
    /* Payload Must Be encrypt */
        String securityCode, securityKey, phoneNumber;
//        try {
//
//        }
        return null;
    }
}