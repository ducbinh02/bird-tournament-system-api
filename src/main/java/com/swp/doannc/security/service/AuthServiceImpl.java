package com.swp.doannc.security.service;

import com.swp.doannc.model.User;
import com.swp.doannc.model.Role;
import com.swp.doannc.repository.UserRepository;
import com.swp.doannc.security.mapper.AuthMapper;
import com.swp.doannc.service.UserValidationService;
import com.swp.doannc.util.GeneralMessageAccessor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.swp.doannc.security.dto.RegistrationRequest;
import com.swp.doannc.security.dto.RegistrationResponse;
import com.swp.doannc.security.dto.AuthenticatedUserDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserValidationService userValidationService;

    private final GeneralMessageAccessor generalMessageAccessor;

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public RegistrationResponse registration(RegistrationRequest registrationRequest) {

        userValidationService.validateUser(registrationRequest);

        final User user = AuthMapper.INSTANCE.convertToUser(registrationRequest);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setEnable(true);

        userRepository.save(user);

        final String email = registrationRequest.getEmail();
        final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, email);

        log.info("{} registered successfully!", email);

        return new RegistrationResponse(registrationSuccessMessage);
    }

    @Override
    public AuthenticatedUserDto findAuthenticatedUserByEmail(String email) {

        final User user = findByEmail(email);

        return AuthMapper.INSTANCE.convertToAuthenticatedUserDto(user);
    }
}
