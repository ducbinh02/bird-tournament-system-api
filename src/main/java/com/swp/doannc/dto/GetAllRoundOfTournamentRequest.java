package com.swp.doannc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetAllRoundOfTournamentRequest {
    @NotEmpty(message = "{tournament_id__not_empty}")
    private Long tournamentId;
}
