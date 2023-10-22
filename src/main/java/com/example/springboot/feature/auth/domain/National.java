package com.example.springboot.feature.auth.domain;

import com.example.springboot.enums.YesOrNo;
import com.example.springboot.global.CreatableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "ntnl_infm")
@NoArgsConstructor
public class National extends CreatableEntity {

    @Id
    @Column(name = "ntnl_cd", length = 2)
    private String nationalCode;

    @Column(name = "natl_nm", length = 100)
    private String nationalName;

    @Column(name = "time_zone", length = 50)
    private String timeZone;

    @Column(name = "natl_num", length = 5)
    private String nationalNumber;

    private String note;

    @Column(name = "reg_id", length = 100)
    private String regId;

    @Column(name = "mod_id", length = 100)
    private String modifiedId;

    @Column(name = "mod_dtm", length = 14)
    private String modifiedDtm;

    @Column(name = "use_yn", length = 1)
    //@Convert(converter = YesOrNo.Converter.class)
    @ColumnDefault("'Y'")
    private YesOrNo useYn;

}