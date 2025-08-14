package com.example.vendotest.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

public class SellerApplicationDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Response{
        Long id;
        String companyName;
        String emailAddress;
        String mobilePhone;
        String companyType;
        String productCategory;
        String tin;
        String province;
        String district;
        String country;
        String referenceCode;
        String status;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Request{
        Long id;
        String companyName;
        String emailAddress;
        String mobilePhone;
        String companyType;
        String productCategory;
        String tin;
        String province;
        String district;
        String country;
        String referenceCode;
    }
}
