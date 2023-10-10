package com.example.springboot.mail;

public interface UserService {
    User findByEmail(String email);

    void save(User user);

     User findByResetToken (String resetToken);

}