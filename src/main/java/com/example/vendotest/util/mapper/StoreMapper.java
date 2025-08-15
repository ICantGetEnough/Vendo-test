package com.example.vendotest.util.mapper;

import com.example.vendotest.domain.dto.StoreDto;
import com.example.vendotest.domain.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StoreMapper {
    StoreDto.Response toDto(Store store);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "user", ignore = true)
    Store toEntity(StoreDto.Request request);
}
