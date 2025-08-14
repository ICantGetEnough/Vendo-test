package com.example.vendotest.util.mapper;

import com.example.vendotest.domain.dto.SellerApplicationDto;
import com.example.vendotest.domain.entity.SellerApplication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SellerApplicationMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "tinVerified", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "applicationStatus", ignore = true)
    SellerApplicationDto.Response toDto(SellerApplication sellerApplication);

    SellerApplication toEntity(SellerApplicationDto.Request request);
}
