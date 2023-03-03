package com.swp.doannc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DisableUserRequest {

    @NotEmpty(message = "{delete_user_id_not_empty}")
    private Long id;
}
