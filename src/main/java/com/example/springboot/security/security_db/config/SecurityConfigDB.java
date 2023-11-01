package com.example.springboot.security.security_db.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/*
@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigDB {

    private final CustomDetailService customDetailService;
    private final PasswordEncoder passwordEncoder;


    */
/**
     * @AuthenticationManagerBuilder << call use from database >>
     *//*


   @Autowired
   public void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(customDetailService).passwordEncoder(passwordEncoder);
   }

    */
/**
     * @SecurityFilterChain << Define permission access endpoint >>
     * @v.2 : authorizeRequests() ==> @v.3  authorizeHttpRequests
     * @v.2 : antMatchers         ==> @v.3  requestMatchers
     *//*

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
            .requestMatchers("/").permitAll()
            .requestMatchers("/admins").hasRole("ADMIN")
            .requestMatchers("/users").hasAnyRole("ADMIN","USER")
        )
        .formLogin(withDefaults());
        return http.build();
    }

}*/