package com.example.springboot.feature.auth.service;

import com.example.springboot.enums.UserRole;
import com.example.springboot.enums.YesOrNo;
import com.example.springboot.feature.auth.domain.SellerCompanyInfo;
import com.example.springboot.feature.auth.domain.UserInfo;
import com.example.springboot.feature.auth.payload.SignupRequest;
import com.example.springboot.feature.auth.repository.CityRepository;
import com.example.springboot.feature.auth.repository.NationalRepository;
import com.example.springboot.feature.auth.repository.SellerCompanyInfoRepository;
import com.example.springboot.feature.auth.repository.UserInfoRepository;
import com.example.springboot.common.controller.StatusCode;
import com.example.springboot.exception.BusinessException;
import com.example.springboot.otp.Otp;
import com.example.springboot.otp.OtpRepository;
import com.example.springboot.utils.DateTimeUtils;
import com.example.springboot.utils.PasswordUtils;
import com.example.springboot.utils.PhoneUtils;
import com.example.springboot.utils.SHA256Utils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static com.example.springboot.utils.DateTimeUtils.VA_FORMATTER_DATE8;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final OtpRepository otpRepository;

    @Value("3m")
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration expiredTime;
    private UserInfoRepository userInfoRepository;
    private PasswordEncoder passwordEncoder;
    private NationalRepository nationalRepository;
    private CityRepository cityRepository;
    private SellerCompanyInfoRepository sellerCompanyInfoRepository;

    //@Transactional /* save */
    @Override
    public void signup(SignupRequest payload) throws NoSuchAlgorithmException {

        /* *************************
        *  Payload Must Be encrypt.
        * ****************************/
        String securityCode, securityKey, phoneNumber;
        try {
            securityKey = PasswordUtils.decrypt(payload.getSecurityKey());
        } catch (Exception e) {
            throw new BusinessException(StatusCode.SECURITY_KEY_MUST_BE_ENCRYPT);
        }
        try {
            securityCode = PasswordUtils.decrypt(payload.getCityCode());
        } catch (Exception e) {
            throw new BusinessException(StatusCode.SECURITY_CODE_MUST_BE_ENCRYPTED);
        }
        try {
            phoneNumber = PasswordUtils.decrypt(payload.getPhonenumber());
        } catch (Exception e) {
            throw new BusinessException(StatusCode.PHONE_NUMBER_INVALID);
        }

        /* Check security code expired*/
        var phone = PhoneUtils.parseNumber(phoneNumber);
        var phoneNumberFormat = PhoneUtils.formatNumberDigitsOnly(phone, PhoneNumberUtil.PhoneNumberFormat.E164);
        Otp otp = otpRepository.findBySecurityIdAndPhoneNumber(securityKey, phoneNumber).orElseThrow(() -> new BusinessException(StatusCode.SECURITY_KEY_NOT_FOUND));

        if(otp.isExpiredInOneMinute(expiredTime)){
            throw new BusinessException(StatusCode.SECURITY_CODE_EXPIRED);
        }

        /* Check security key not found*/
        String encryptedKey = new SHA256Utils(securityKey).encrypt(securityCode);
        if (!otp.getSecurityCode().equals(encryptedKey)) {
            throw new BusinessException(StatusCode.SECURITY_CODE_NOT_FOUND);
        }

        var user = userInfoRepository.findByUserId(payload.getUserId());
        if (user.isPresent()) {
            throw new BusinessException(StatusCode.USER_ID_EXIST);
        }

        String rawPassword;
        try {
            rawPassword = passwordEncoder.encode(PasswordUtils.decrypt(payload.getPassword()));
        } catch (Exception e) {
            throw new BusinessException(StatusCode.CURRENT_PASSWORD_MUST_BE_ENCRYPTED);
        }

        var national = nationalRepository.findByNationalCode(payload.getNationalCode()).orElseThrow(() -> new BusinessException(StatusCode.NATIONAL_NOT_FOUND));

        var city = cityRepository.findByNationalCodeAndName(national.getNationalCode(), payload.getCityCode()).orElseThrow(() -> new BusinessException(StatusCode.CITY_NOT_FOUND));

        var sellerCompanyInfo = SellerCompanyInfo.builder()
                .sellerCompanyTaxCode(payload.getTaxId())
                .companyLocalName(payload.getBusinessName())
                .representativeName(payload.getRepresentativeName())
                .companyAddress(payload.getAddress())
                .nationalCode(national.getNationalCode())
                //.cityCode(city.getId().getCountryCode()).delYn(YesOrNo.NO)
                .build();
        var sellerCompanyInfoEntity = sellerCompanyInfoRepository.save(sellerCompanyInfo);

        StringBuilder employeeNumber = new StringBuilder();
        employeeNumber.append(DateTimeUtils.ictNow().format(VA_FORMATTER_DATE8));
        employeeNumber.append(StringUtils.leftPad("1", 3, "0"));

        var userInfo = UserInfo.builder()
                .userId(payload.getUserId())
                .userName(payload.getFullname())
                .userPassword(rawPassword)
                .userRole(UserRole.USER.getValue())
                .telephone(phoneNumber)
                .userEmail(payload.getEmail())
                .activeYn(YesOrNo.YES)
                //.lockingYn(YesOrNo.NO)
                .sellerCompanyInfo(sellerCompanyInfoEntity)
                //.employeeNumber(String.valueOf(employeeNumber))
                //.deleteYn(YesOrNo.NO)
                .build();
        userInfoRepository.save(userInfo);

    }
}