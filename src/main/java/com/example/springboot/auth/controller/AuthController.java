package com.example.springboot.auth.controller;

import com.example.springboot.auth.payload.SignupRequest;
import com.example.springboot.auth.service.AuthService;
import com.example.springboot.common.controller.BestResponseController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController extends BestResponseController {
    private final AuthService authService;
    @PostMapping("/signup")
    public Object singUp(@RequestBody @Valid SignupRequest payload){
        authService.signUp(payload);
        return ok();
    }

}