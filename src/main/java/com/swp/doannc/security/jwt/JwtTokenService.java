package com.swp.doannc.security.jwt;

import com.swp.doannc.exception.DisabledEntityException;
import com.swp.doannc.model.User;
import com.swp.doannc.security.dto.AuthenticatedUserDto;
import com.swp.doannc.security.dto.LoginRequest;
import com.swp.doannc.security.dto.LoginResponse;
import com.swp.doannc.security.mapper.AuthMapper;
import com.swp.doannc.security.service.AuthService;
import com.swp.doannc.service.UserValidationService;
import com.swp.doannc.util.ExceptionMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {


    private static final String LOGIN_WITH_DISABLED_ACCOUNT = "login_disabled_account";
    private final AuthService userService;

    private final JwtTokenManager jwtTokenManager;

    private final UserValidationService userValidationService;
    private final AuthenticationManager authenticationManager;

    private final ExceptionMessageAccessor exceptionMessageAccessor;

    public LoginResponse getLoginResponse(LoginRequest loginRequest) {

        final String email = loginRequest.getEmail();
        final String password = loginRequest.getPassword();

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        final AuthenticatedUserDto authenticatedUserDto = userService.findAuthenticatedUserByEmail(email);

        userValidationService.checkDisable(email);

        final User user = AuthMapper.INSTANCE.convertToUser(authenticatedUserDto);
        final String token = jwtTokenManager.generateToken(user);

        log.info("{} has successfully logged in!", user.getEmail());

        return new LoginResponse(token);
    }

}