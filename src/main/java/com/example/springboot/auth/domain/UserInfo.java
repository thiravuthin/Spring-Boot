package com.example.springboot.auth.domain;


import com.example.springboot.common.domain.UpdatableEntity;
import jakarta.persistence.*;
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

    @Column(name = "EMPL_NO",length = 20)
    private String employeeNumber;

    @Column(name = "USER_IMG",length = 500)
    private String userImage;

    /*@Column(name = "USER_STS",length = 1)
    @Convert(converter = YesOrNo.Converter.class)
    private YesOrNo userStatus;

    @Column(name = "WAB_BIZ_KEY")
    private String wabBizKey;

    @Column(name = "WAB_USER_ID")
    private String waBooksUserId;

    @Column(name = "WAB_USER_PW")
    private String waBooksUserPwd;

    @Column(name = "ACTIV_YN",length = 1)
    @Convert(converter = YesOrNo.Converter.class)
    private YesOrNo activeYn;

    @Column(name = "LOCK_YN",length = 1)
    @Convert(converter = YesOrNo.Converter.class)
    private YesOrNo lockingYn;


    @Column(name = "DEL_YN",length = 1)
    @Convert(converter = YesOrNo.Converter.class)
    private YesOrNo deleteYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMP_ID")
    private SellerCompanyInfo sellerCompanyInfo;


    @OneToMany(mappedBy = "userInfo",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<UserShopConn> userShopConns;

    public UserInfo(String userId) {
        this.userId = userId;
    }

    @Builder
    public UserInfo(String userId, String userName, String userPassword, String userRole, String telephone, String userEmail, String employeeNumber, String userImage, YesOrNo userStatus, String wabBizKey, String waBooksUserId, String waBooksUserPwd, YesOrNo activeYn, YesOrNo lockingYn, YesOrNo deleteYn, SellerCompanyInfo sellerCompanyInfo, List<UserShopConn> userShopConns) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.telephone = telephone;
        this.userEmail = userEmail;
        this.employeeNumber = employeeNumber;
        this.userImage = userImage;
        this.userStatus = userStatus;
        this.wabBizKey = wabBizKey;
        this.waBooksUserId = waBooksUserId;
        this.waBooksUserPwd = waBooksUserPwd;
        this.activeYn = activeYn;
        this.lockingYn = lockingYn;
        this.deleteYn = deleteYn;
        this.sellerCompanyInfo = sellerCompanyInfo;
        this.userShopConns = userShopConns;
    }*/
}