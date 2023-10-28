package com.example.springboot.mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByResetToken(String resetToken);

}