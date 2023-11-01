package com.example.springboot.security.security_jwt.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USER_JWT")
@Getter
@Setter
@NoArgsConstructor
public class UserJwt implements UserDetails {

    @Id
    @Column(name = "USERNAME")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    private Rols rols;
    @Builder
    public UserJwt(Long id, String firstName, String lastName, String email, String password, Rols rols) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rols = rols;
    }

    /**
     * @GrantedAuthority will return list of role
     **/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rols.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}