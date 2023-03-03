
package com.swp.doannc.security.dto;

import com.swp.doannc.model.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * LoginRequest
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

  private String name;

  private String email;

  private String password;

  private Role role;

  private boolean isEnable;
}
