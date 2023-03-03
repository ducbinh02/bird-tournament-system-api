package com.swp.doannc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JoinTournamentRequest {
    @NotEmpty(message = "{join_tournament_id_not_empty}")
    private Long tournamentId;

    @NotEmpty(message = "{bird_id_not_empty}")
    private Long birdId;


}
