package com.swp.doannc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetRoundOfTournamentRequest {
    @NotEmpty(message = "{round_id__not_empty}")
    private Long roundId;
}
