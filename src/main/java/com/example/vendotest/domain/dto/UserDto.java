package com.example.vendotest.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

public class UserDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Response{
        String firstName;
        String lastName;
        String passwordHash;
        SellerApplicationDto.Response response;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Request{
        String firstName;
        String lastName;
        String passwordHash;
    }
}
