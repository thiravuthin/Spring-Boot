package com.example.springboot.common.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    SUCCESS("Success", 200),
    SECURITY_KEY_MUST_BE_ENCRYPT("The security key must be encrypt!", 500),
    SECURITY_CODE_MUST_BE_ENCRYPTED("The security code must be encrypt!", 500),
    PHONE_NUMBER_INVALID("phone number invalid",500 ),
    SECURITY_KEY_NOT_FOUND("Security key not found", 500 ),
    SECURITY_CODE_EXPIRED("Security code expired",500 ),
    SECURITY_CODE_NOT_FOUND("Security key not found!", 500),
    USER_ID_EXIST("User Id exist",401 ),
    CURRENT_PASSWORD_MUST_BE_ENCRYPTED("Current password must be encrypt",500 ),
    NATIONAL_NOT_FOUND("National not found!",500 ),
    CITY_NOT_FOUND("City not found!",500 ),
   UNAUTHORIZED("Unauthorized", 500);
    private final String message;
    private final int code;
}