package com.example.springboot.security.security_db.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_tb")
@Getter
@Setter
@NoArgsConstructor
public class UserDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;


    private String password;

    private String authentication;

    @Builder
    public UserDB(Long id, String userName, String password, String authentication) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authentication = authentication;
    }
}