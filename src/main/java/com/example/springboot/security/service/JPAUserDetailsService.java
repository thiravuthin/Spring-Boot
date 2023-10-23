package com.example.springboot.security.service;

import com.example.springboot.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JPAUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public SecurityUser loadUserByUsername(String username){
        var user = userRepository.findByUseName(username);
        return user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
    }

}