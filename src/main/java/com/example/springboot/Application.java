package com.example.springboot;

import com.example.springboot.utils.PasswordUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.err.println(PasswordUtils.encrypt("vuthin"));
        System.err.println(PasswordUtils.decrypt("76EGC60uPmgDgkC19wJj6g=="));
    }


}