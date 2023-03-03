package com.swp.doannc.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserRequest extends UpdateProfileRequest {

    @NotEmpty(message = "{update_user_id_not_empty}")
    private Long userId;
}
