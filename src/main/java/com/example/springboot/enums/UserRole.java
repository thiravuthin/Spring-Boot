package com.example.springboot.enums;


/**
 * A class can be used for getting Status enum
 */
public enum UserRole  {
    USER("USER"),
    Admin("ADMIN"),
    ;

    private final String value;

    UserRole(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.err.println(UserRole.USER.getValue());
    }
}