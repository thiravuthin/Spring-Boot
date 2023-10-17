package com.example.springboot.exception;


import com.example.springboot.common.controller.StatusCode;

/**
 * Handle exception for Business Exception
 */
public class BusinessException extends RuntimeException {

    private final StatusCode errorCode;

    public BusinessException(StatusCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;

    }

    public BusinessException(StatusCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public StatusCode getErrorCode() {
        return errorCode;
    }


}