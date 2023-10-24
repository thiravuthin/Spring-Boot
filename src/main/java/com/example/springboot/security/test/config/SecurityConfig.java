package com.example.springboot.security.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *  Some of Keys work Spring Security
 *  Authorities = អាជ្ញាធរ
 *  Authentication =
 */

/**
 * In Security Config always I have 2
 * - PasswordEncoder
 * - UserDetailService  ( We can implement own user detailService )
 */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {

    /**
     * In Memory
     *
     * @Bean // loadUserByUsername
     * public UserDetailsService userDetailsService(){
     * var uds = new InMemoryUserDetailsManager();
     * <p>
     * var u1 = User.withUsername("vuthin")
     * .password("123")
     * .authorities("read")
     * .build();
     * <p>
     * uds.createUser(u1);
     * <p>
     * return uds;
     * }
     * @Bean public PasswordEncoder passwordEncoder(){
     * return NoOpPasswordEncoder.getInstance();
     * }
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}