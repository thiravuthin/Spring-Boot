package com.example.springboot.mail;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String resetToken;

    @Builder
    public User(Long id, String email, String password, String resetToken) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.resetToken = resetToken;
    }


}