package com.example.vendotest.util.mapper;

import com.example.vendotest.domain.dto.UserDetailDto;
import com.example.vendotest.domain.entity.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserDetailMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "user", ignore = true)
    UserDetailDto.Response toDto(UserDetail userDetail);

    UserDetail toEntity(UserDetailDto.Request request);
}
