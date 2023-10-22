package com.example.springboot.utils;

import org.springframework.lang.NonNull;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTimeUtils {
    private static final String VA_PATTERN_DTM14 = "yyyyMMddHHmmss";
    private static final String VA_PATTERN_DATE8 = "yyyyMMdd";

    public static final DateTimeFormatter VA_FORMATTER_DATE8 = DateTimeFormatter.ofPattern(VA_PATTERN_DATE8);
    public static final DateTimeFormatter VA_FORMATTER_DTM14 = DateTimeFormatter.ofPattern(VA_PATTERN_DTM14);
    public static final Clock clock = Clock.system(TimeZone.getDefault().toZoneId());
    public static LocalDateTime ictNow() {
        return LocalDateTime.now(clock);
    }
    public static LocalDateTime parseDateTime(@NonNull String dateTime) {
        return LocalDateTime.parse(dateTime, VA_FORMATTER_DTM14);
    }

    public static void main(String[] args) {
        System.err.println(DateTimeUtils.VA_PATTERN_DTM14);
    }

}