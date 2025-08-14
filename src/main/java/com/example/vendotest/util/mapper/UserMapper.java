package com.example.vendotest.util.mapper;

import com.example.vendotest.domain.dto.UserDto;
import com.example.vendotest.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "sellerApplication", ignore = true)
    UserDto.Response toDto(User user);

    User toEntity(UserDto.Request request);
}
