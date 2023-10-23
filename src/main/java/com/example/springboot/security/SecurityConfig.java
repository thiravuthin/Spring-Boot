package com.example.springboot.security;

import com.example.springboot.security.repository.UserRepository;
import com.example.springboot.security.service.JPAUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/*****************************************************************************
 *    We use class SecurityConfig cuz wanna custom use own password and user *
 * ***************************************************************************/

/*
 *   Authorities = អាជ្ញាធរ
 */

/*
 *   In Security Config always I have 2:
 *   - PasswordEncoder
 *   - UserDetailService  ( We can implement own user detailService )
 */

@Configuration
public class SecurityConfig {

    /* ***************( In Memory )***********************
     *    @Bean
     *     // loadUserByUsername
     *     public UserDetailsService userDetailsService(){
     *         var uds = new InMemoryUserDetailsManager();
     *
     *         var u1 = User.withUsername("vuthin")
     *                 .password("123")
     *                 .authorities("read")
     *                 .build();
     *
     *         uds.createUser(u1);
     *
     *         return uds;
     *     }
     *
     *     @Bean
     *     public PasswordEncoder passwordEncoder(){
     *         return NoOpPasswordEncoder.getInstance();
     *     }
     * *******************************************************/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}