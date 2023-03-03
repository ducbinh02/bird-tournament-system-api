package com.swp.doannc.security.service;

import com.swp.doannc.model.User;
import com.swp.doannc.security.dto.AuthenticatedUserDto;
import com.swp.doannc.security.dto.RegistrationRequest;
import com.swp.doannc.security.dto.RegistrationResponse;

public interface AuthService {
    User findByEmail(String email);

    RegistrationResponse registration(RegistrationRequest registrationRequest);

    AuthenticatedUserDto findAuthenticatedUserByEmail(String email);
}