package com.swp.doannc.mapper;

import com.swp.doannc.dto.UpdateProfileRequest;
import com.swp.doannc.dto.UpdateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", ignore = true)
    UpdateUserRequest convertToUpdateUserRequest(UpdateProfileRequest updateProfileRequest);
}
