package com.swp.doannc.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * LoginRequest
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
  @NotEmpty(message = "{login_email_is_not_valid}")
  @Email(message = "{login_email_wrong_format}")
  private String email;

  @NotEmpty(message = "{login_password_not_empty}")
  private String password;
}
