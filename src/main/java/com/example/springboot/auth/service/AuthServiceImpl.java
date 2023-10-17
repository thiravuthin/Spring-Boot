package com.example.springboot.auth.service;

import com.example.springboot.auth.payload.SignupRequest;
import com.example.springboot.common.controller.StatusCode;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.prefs.BackingStoreException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    //@Transactional /* save */
    @Override
    public Object signUp(SignupRequest payload) {
    /* Payload Must Be encrypt */
        String securityCode, securityKey, phoneNumber;
        try {
            securityKey = PasswordUtils.decrypt(payload.getSecurityKey());
        }catch (Exception e){
            throw new BusinessException(StatusCode.SUCCESS);
        }
        return null;
    }
}