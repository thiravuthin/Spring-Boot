package com.example.springboot.otp;

import com.example.springboot.common.DateTimeConverter;
import com.example.springboot.common.domain.UpdatableEntity;
import com.example.springboot.enums.YesOrNo;
import com.example.springboot.utils.DateTimeUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Tolerate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;
@Entity
@Table(name = "otp_his")
@Setter
@Getter
@NoArgsConstructor
public class Otp extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sec_id")
    private String securityId;

    @Column(name = "sec_code")
    private String securityCode;

    @Column(name = "tel_no")
    private String telephone;

    @Column(name = "VERI_YN",length = 1)
    //@Convert(converter = YesOrNo.Converter.class)
    private YesOrNo verifyYn;

    @Column(name = "cnt_fail")
    private Integer countFail;

    @Column(name = "disa_dtm")
    private String disableDatetime;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "sms_log_id")
    //private SmsLog smsLog;

    @Column(name = "resp_cd", length = 10)
    private String responseCode;

    @Column(name = "resp_msg", columnDefinition = "TEXT")
    private String responseMessage;

    @Convert(converter = DateTimeConverter.class)
    @Column(name = "resp_dtm")
    private LocalDateTime responseDateTime;


    @JsonIgnore
    @Tolerate
    public boolean isExpiredInOneMinute(Duration expiration) {
        ZoneId idcZone = TimeZone.getDefault().toZoneId();
        Duration timeElapsed = Duration.between(DateTimeUtils.parseDateTime(getRegDtm()).atZone(idcZone).withZoneSameLocal(idcZone), ZonedDateTime.now(idcZone));
        return timeElapsed.toMillis() > expiration.getSeconds() * 1000;
    }

    @JsonIgnore
    @Tolerate
    public boolean isExpiredInThirtyMinutes() {
        ZoneId idcZone = TimeZone.getDefault().toZoneId();
        Duration timeElapsed = Duration.between(DateTimeUtils.parseDateTime(getRegDtm()).atZone(idcZone).withZoneSameLocal(idcZone), ZonedDateTime.now(idcZone));
        return timeElapsed.toMillis() > 60 * 1000 * 30;
    }

    @JsonIgnore
    @Tolerate
    public boolean isExpiredInTenMinutes() {
        ZoneId idcZone = TimeZone.getDefault().toZoneId();
        Duration timeElapsed = Duration.between(DateTimeUtils.parseDateTime(getRegDtm()).atZone(idcZone).withZoneSameLocal(idcZone), ZonedDateTime.now(idcZone));
        return timeElapsed.toMillis() > 60 * 1000 * 10;
    }
    @Builder
    public Otp(Long id, String securityId, String securityCode, String telephone, YesOrNo verifyYn, Integer countFail, String disableDatetime, String responseCode, String responseMessage, LocalDateTime responseDateTime) {
        this.id = id;
        this.securityId = securityId;
        this.securityCode = securityCode;
        this.telephone = telephone;
        this.verifyYn = verifyYn;
        this.countFail = countFail;
        this.disableDatetime = disableDatetime;
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseDateTime = responseDateTime;
    }
}