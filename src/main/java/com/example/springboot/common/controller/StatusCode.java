package com.example.springboot.common.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    SUCCESS("Success", 200),
    SECURITY_KEY_MUST_BE_ENCRYPT("The security key must be encrypt!", 500),
    SECURITY_CODE_MUST_BE_ENCRYPTED("The security code must be encrypt!", 500),
    PHONE_NUMBER_INVALID("phone number invalid",500 );

    private final String message;
    private final int code;
}