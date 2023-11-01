package com.example.springboot.security.security_db.config;

import com.example.springboot.security.security_db.domain.UserDB;
import com.example.springboot.security.security_db.repository.UserDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
@RequiredArgsConstructor
@Service
public class CustomDetailService implements UserDetailsService {

    private final UserDBRepository userDBRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDB user = userDBRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return new CustomUserDetails(user.getUserName(), user.getPassword(), user.getAuthentication());
    }
}*/