package com.example.springboot.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userIM = new InMemoryUserDetailsManager();
        var user1 = User
                .withUsername("vuthin")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        var user2 = User
                .withUsername("dybola")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        userIM.createUser(user1);
        userIM.createUser(user2);

        return userIM;
    }


    /**
     * Define the link which one who can access
     */
    @Bean
    public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/").permitAll()
                            .requestMatchers("/admin").hasRole("ADMIN")
                            .anyRequest()
                            .authenticated();
                })
                .formLogin(Customizer.withDefaults());
        return http.build();
    }




}