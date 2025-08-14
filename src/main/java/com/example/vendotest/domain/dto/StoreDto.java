package com.example.vendotest.domain.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

public class StoreDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Response{
        String brandName;
        String brandDescription;
        String coverPhotoPath;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Request {
        String brandName;
        String brandDescription;
        String coverPhotoPath;
    }
}
