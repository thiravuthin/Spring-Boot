package com.example.springboot.utils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class DateTimeUtils {
    private static final String VA_PATTERN_DTM14 = "yyyyMMddHHmmss";


    public static final DateTimeFormatter VA_FORMATTER_DTM14 = DateTimeFormatter.ofPattern(VA_PATTERN_DTM14);
    public static final Clock clock = Clock.system(TimeZone.getDefault().toZoneId());
    public static LocalDateTime ictNow() {
        return LocalDateTime.now(clock);
    }

    public static void main(String[] args) {
//        System.err.println(LocalDateTime.parse("2023-09-21").format());
    }

}