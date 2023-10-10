package com.example.springboot.common.domain;

import com.example.springboot.constants.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.generator.EventType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CreatableEntity {

    @GeneratedDateTime(timing = EventType.INSERT)
    @Column(updatable = false, name = "reg_dtm", length = Constants.DATETIME_LENGTH)
    private String regDtm;

}