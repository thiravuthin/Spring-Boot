package com.example.springboot.utils;


import com.example.springboot.common.AppLogManager;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.security.core.parameters.P;


public class PhoneUtils {

    final public static String DEFAULT_COUNTRY_CODE = "VN";

    /* Handle on Country Code*/
    public static Phonenumber.PhoneNumber parseNumber(String str) {
        try {
            return PhoneNumberUtil.getInstance().parse(str, DEFAULT_COUNTRY_CODE);
        } catch (NumberParseException e) {
            AppLogManager.error(e);
        }
        return null;
    }

    /*FormatNumberDigitsOnly*/
    public static String formatNumberDigitsOnly(Phonenumber.PhoneNumber phoneNumber, PhoneNumberUtil.PhoneNumberFormat numberFormat) {
        return PhoneNumberUtil.normalizeDigitsOnly(formatNumber(phoneNumber, numberFormat));
    }

    public static String formatNumber(Phonenumber.PhoneNumber phoneNumber, PhoneNumberUtil.PhoneNumberFormat numberFormat) {
        String digitsOnly = PhoneNumberUtil.getInstance().format(phoneNumber, numberFormat);
        return addZeroToNumber(digitsOnly);
    }
    public static String addZeroToNumber(String phoneNumber){
        return phoneNumber;
    }

    public static void main(String[] args) {
        System.err.println(PhoneUtils.parseNumber("964141077"));
        var tele = PhoneUtils.parseNumber("964141077");
        System.err.println(PhoneUtils.formatNumberDigitsOnly(tele, PhoneNumberUtil.PhoneNumberFormat.E164));
    }

}