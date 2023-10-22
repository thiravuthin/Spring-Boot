package com.example.springboot.feature.auth.payload;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignupRequest {

        @NotBlank
        @Length(max = 40)
        private String taxId;

        @NotBlank
        @Length(max = 100)
        private String businessName;

        @NotBlank
        @Length(max = 100)
        private String representativeName;

        @NotBlank
        @Length(max = 400)
        private String address;


        @Length(max = 400)
        private String cityCode;

        @NotBlank
        @Length(max = 3)
        private String nationalCode;

        @NotBlank
        @Length(max = 100)
        private String fullname;

        @NotBlank
        @Length(max = 100)
        private String email;

        @NotBlank
        private String phonenumber;


        @Email
        @NotBlank
        @Length(max = 100)
        private String userId;


        @NotBlank
        @Length(max = 150)
        private String password;


        @NotBlank
        private String securityCode;

        @NotBlank
        private String securityKey;

        @Builder
        public SignupRequest(String taxId, String businessName, String representativeName, String address, String cityCode, String nationalCode, String fullname, String email, String phonenumber, String userId, String password, String securityCode, String securityKey) {
                this.taxId = taxId;
                this.businessName = businessName;
                this.representativeName = representativeName;
                this.address = address;
                this.cityCode = cityCode;
                this.nationalCode = nationalCode;
                this.fullname = fullname;
                this.email = email;
                this.phonenumber = phonenumber;
                this.userId = userId;
                this.password = password;
                this.securityCode = securityCode;
                this.securityKey = securityKey;
        }
}