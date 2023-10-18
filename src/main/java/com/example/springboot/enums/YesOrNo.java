package com.example.springboot.enums;
public enum YesOrNo {
    YES("Y"),
    NO("N"),
    ;

    private final String value;

    YesOrNo(String value) {
        this.value = value;
    }


}