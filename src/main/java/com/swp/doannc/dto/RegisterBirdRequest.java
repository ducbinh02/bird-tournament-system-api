package com.swp.doannc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterBirdRequest {

    @NotEmpty(message = "{bird_name_is_not_empty}")
    private String name;

    @NotEmpty(message = "{bird_age_is_not_empty}")
    private int age;

    @NotEmpty(message = "{bird_type_is_not_empty}")
    private String type;

    @NotEmpty(message = "{bird_weigh_is_not_empty}")
    private float weight;

    @NotEmpty(message = "{bird_gender_is_not_empty}")
    private boolean gender;

    private String avatarUrl;
}
