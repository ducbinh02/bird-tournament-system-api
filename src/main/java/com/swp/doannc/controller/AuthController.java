package com.swp.doannc.controller;

import com.swp.doannc.security.dto.LoginRequest;
import com.swp.doannc.security.dto.LoginResponse;
import com.swp.doannc.security.dto.RegistrationRequest;
import com.swp.doannc.security.dto.RegistrationResponse;
import com.swp.doannc.security.jwt.JwtTokenService;
import com.swp.doannc.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    private final JwtTokenService jwtService;

    @PostMapping("/signIn")
    ResponseEntity<LoginResponse> signIn(@Valid @RequestBody LoginRequest loginRequest) {

        final LoginResponse loginResponse = jwtService.getLoginResponse(loginRequest);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/signUp")
    public ResponseEntity<RegistrationResponse> registrationRequest(@Valid @RequestBody RegistrationRequest registrationRequest) {

        final RegistrationResponse registrationResponse = authService.registration(registrationRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
    }
}
