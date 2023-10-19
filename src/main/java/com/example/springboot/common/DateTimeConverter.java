package com.example.springboot.common;

import com.example.springboot.utils.DateTimeUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;

@Converter
public class DateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    /************************************************************************
    * Handle convert LocalDataTime to ```yyyyMMddHHmmss``` when store in DB
    * ***********************************************************************/
    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute) {
        return attribute == null ? null : attribute.format(DateTimeUtils.VA_FORMATTER_DTM14);
    }

    /****************************
    * Protect Entity if data null
    * ****************************/
    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        return dbData == null ? null :  DateTimeUtils.parseDateTime(dbData);
    }
}