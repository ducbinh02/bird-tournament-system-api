package com.swp.doannc.mapper;

import com.swp.doannc.dto.AddBirdPointRequest;
import com.swp.doannc.model.Score;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoundMapper {
    RoundMapper INSTANCE = Mappers.getMapper(RoundMapper.class);

    @Mapping(target = "isEnable", ignore = true)
    @Mapping(target = "id", ignore = true)
    Score convertToScore(AddBirdPointRequest addBirdPointRequest);
}
