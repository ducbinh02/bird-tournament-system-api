package com.swp.doannc.mapper;

import com.swp.doannc.dto.RegisterBirdRequest;
import com.swp.doannc.model.Bird;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BirdMapper {
    BirdMapper INSTANCE = Mappers.getMapper(BirdMapper.class);

    @Mapping(target = "ownerId", ignore = true)
    @Mapping(target = "isEnable", ignore = true)
    @Mapping(target = "id", ignore = true)
    Bird convertToBird(RegisterBirdRequest registerBirdRequest);
}
