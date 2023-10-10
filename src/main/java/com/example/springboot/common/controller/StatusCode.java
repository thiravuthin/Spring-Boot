package com.example.springboot.common.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    SUCCESS("Success", 200);

    private final String message;
    private final int code;



}