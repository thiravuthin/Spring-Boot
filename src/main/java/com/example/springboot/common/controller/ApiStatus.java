package com.example.springboot.common.controller;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiStatus {
    private int code;
    private String message;

    public ApiStatus(StatusCode statusCode) {
    }

   /* @Builder
    public ApiStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }*/

}