package com.example.springboot.common.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    SUCCESS("Success", 200),

    SECURITY_KEY_MUST_BE_ENCRYPT("The security key must be encrypt!", 500);


    private final String message;
    private final int code;



}