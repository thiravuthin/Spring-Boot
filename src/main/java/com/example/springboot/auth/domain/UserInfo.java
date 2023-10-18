package com.example.springboot.auth.domain;


import com.example.springboot.common.domain.UpdatableEntity;
import com.example.springboot.enums.YesOrNo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USER_ID",length = 100, nullable = false)
    private String userId;

    @Column(name = "USER_NM", length = 100,nullable = false)
    private String userName;

    @Column(name = "USER_PWD", length = 150,nullable = false)
    private String userPassword;

    @Column(name = "ROLE", length = 50)
    private String userRole;

    @Column(name = "TEL_NO",length = 20,nullable = false)
    private String telephone;

    @Column(name = "USER_EML",length = 100,nullable = false)
    private String userEmail;

    @Column(name = "ACTIV_YN",length = 1)
   // @Convert(converter = YesOrNo.Converter.class)
    private YesOrNo activeYn;

    @Builder
    public UserInfo(Long id, String userId, String userName, String userPassword, String userRole, String telephone, String userEmail, YesOrNo activeYn) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.telephone = telephone;
        this.userEmail = userEmail;
        this.activeYn = activeYn;
    }
}