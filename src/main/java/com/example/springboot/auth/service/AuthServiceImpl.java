package com.example.springboot.auth.service;

import com.example.springboot.auth.payload.SignupRequest;
import com.example.springboot.common.controller.StatusCode;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    //@Transactional /* save */
    @Override
    public void signup(SignupRequest payload) {

        /* Payload Must Be encrypt */
        String securityCode, securityKey, phoneNumber;
        try {
            securityKey = PasswordUtils.decrypt(payload.getSecurityKey());
        } catch (Exception e) {
            throw new BusinessException(StatusCode.SECURITY_KEY_MUST_BE_ENCRYPT);
        }
        try {
            securityCode = PasswordUtils.decrypt(payload.getCityCode());
        } catch (Exception e) {
            throw new BusinessException(StatusCode.SECURITY_CODE_MUST_BE_ENCRYPTED);
        }
        try {
            phoneNumber = PasswordUtils.decrypt(payload.getPhonenumber());
        } catch (Exception e) {
            throw new BusinessException(StatusCode.PHONE_NUMBER_INVALID);
        }

        /* check security code expired*/

    }
}