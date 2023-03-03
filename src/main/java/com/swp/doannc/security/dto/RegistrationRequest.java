package com.swp.doannc.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * RegistrationRequest
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistrationRequest {

  @NotEmpty(message = "{registration_name_not_empty}")
  private String name;

  @Email(message = "{registration_email_is_not_valid}")
  @NotEmpty(message = "{registration_email_not_empty}")
  private String email;

  @NotEmpty(message = "{registration_password_not_empty}")
  private String password;

  @NotEmpty(message = "{registration_phone_not_empty}")
  private String phone;

  @NotEmpty(message = "{registration_address_not_empty}")
  private String address;

}
