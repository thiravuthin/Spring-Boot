package com.example.springboot.security.security_in_memory;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
//@Configuration
public class InMemorySecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @UserDetailsService => Store users.
     */

    @Bean
    public UserDetailsService userDetailsService() {
        var userIM = new InMemoryUserDetailsManager();
        var user1 = User
                .withUsername("vuthin")
                .password(passwordEncoder().encode("123"))
                .roles("MANAGER")
                .build();

        var user2 = User
                .withUsername("dybola")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        var user3 = User
                .withUsername("dara")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();

        userIM.createUser(user1);
        userIM.createUser(user2);
        userIM.createUser(user3);

        return userIM;
    }


    /**
     * @SecurityFilterChain => Define the link which one who can access.
     **/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/home").permitAll()  //Can access without login
                            .requestMatchers("/user").hasRole("ADMIN")
                            .requestMatchers("/admin").hasAnyRole("ADMIN", "USER")
                            .anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}