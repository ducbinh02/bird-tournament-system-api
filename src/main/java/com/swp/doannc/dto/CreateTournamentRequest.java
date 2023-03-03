package com.swp.doannc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTournamentRequest {

    private String name;

    private String description;

    private String capacity;

    private String location;

    private Double minimumAge;

    private Double minimumWeight;

    private Long ruleId;
}
