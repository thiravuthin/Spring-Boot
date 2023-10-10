package com.example.springboot.common.domain;

import com.example.springboot.constants.Constants;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.generator.EventType;

@Getter
@Setter
//@MappedSuperclass
public class UpdatableEntity extends CreatableEntity {
    @GeneratedDateTime(timing = EventType.UPDATE)
    @Column(name = "chng_dtm", length = Constants.DATETIME_LENGTH)
    private String changeDtm;

}