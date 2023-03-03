package com.swp.doannc.mapper;


import com.swp.doannc.dto.CreateTournamentRequest;
import com.swp.doannc.model.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TournamentMapper {
    TournamentMapper INSTANCE = Mappers.getMapper(TournamentMapper.class);

    @Mapping(target = "isEnable", ignore = true)
    @Mapping(target = "id", ignore = true)
    Tournament convertToTournament(CreateTournamentRequest createTournamentRequest);
}
