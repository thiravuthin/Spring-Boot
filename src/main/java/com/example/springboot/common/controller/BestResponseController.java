package com.example.springboot.common.controller;

import org.springframework.http.HttpStatus;


public abstract class BestResponseController {
    public HttpStatus ok(){
        return HttpStatus.OK;
    }

}