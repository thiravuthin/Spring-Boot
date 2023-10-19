package com.example.springboot.common;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class AppLogManager {
    public static void error(Throwable ex) {
        String[] parsed = parseCaller(ex.getMessage());
        error(parsed[0], ex.getMessage(), ex);
    }

    public static void error(String category, Object x, Throwable ex) {
        Logger logger = LoggerFactory.getLogger(category);
        error(logger, String.valueOf(x), ex);
    }
    private static void error(Logger logger, Object x, Throwable ex) {
        logger.error("####################################################################################################");
        logger.error(String.valueOf(x));
        logger.error("####################################################################################################");

        if(ex != null) {
            ex.printStackTrace();
        }
    }

    private static String[] parseCaller(Object x) {
        return parseCaller(getCallerAsString(3), String.valueOf(x));
    }
    private static String[] parseCaller(String str, Object x) {
        return new String[]{
                str,
                MessageFormat.format("{0}:{1} - {2}",
                        StringUtils.substringAfterLast(str, ".") + ".java",
                        Thread.currentThread().getStackTrace()[4].getLineNumber(),
                        String.valueOf(x))
        };
    }

    private static String getCallerAsString(int level) {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String rawFQN = stElements[level + 1].toString().split("\\(")[0];
        return rawFQN.substring(0, StringUtils.lastIndexOf(rawFQN, "."));
    }

};