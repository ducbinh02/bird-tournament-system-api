package com.swp.doannc.service;

import com.swp.doannc.exception.DisabledEntityException;
import com.swp.doannc.exception.RegistrationException;
import com.swp.doannc.repository.UserRepository;
import com.swp.doannc.security.dto.RegistrationRequest;
import com.swp.doannc.util.ExceptionMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * UserValidationService
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidationService {
    private static final String EMAIL_ALREADY_EXISTS = "email_already_exists";

    private static final String DISABLED_ENTITY = "disabled_entity";
    private static final String NOT_EXISTS_USER = "not_exists_user";

    private static final String PHONE_ALREADY_EXISTS = "phone_already_exists";

    private final UserRepository userRepository;

    private final ExceptionMessageAccessor exceptionMessageAccessor;

    public void validateUser(RegistrationRequest registrationRequest) {

        final String email = registrationRequest.getEmail();
        final String phone = registrationRequest.getPhone();

        checkEmail(email);
        checkPhone(phone);
    }

    private void checkPhone(String phone) {

        final boolean existsByPhone = userRepository.existsByPhone(phone);

        if (existsByPhone) {

            log.warn("{} is already being used!", phone);

            final String existsPhone = exceptionMessageAccessor.getMessage(null, PHONE_ALREADY_EXISTS);
            throw new RegistrationException(existsPhone);
        }

    }

    private void checkEmail(String email) {

        final boolean existsByEmail = userRepository.existsByEmail(email);

        if (existsByEmail) {

            log.warn("{} is already being used!", email);

            final String existsEmail = exceptionMessageAccessor.getMessage(null, EMAIL_ALREADY_EXISTS);
            throw new RegistrationException(existsEmail);
        }
    }

    public void checkDisable(String email) {
        final boolean isEnable = userRepository.findByEmail(email).isEnable();

        if (!isEnable) {

            log.warn("{} has already been disabled!", email);

            final String message = exceptionMessageAccessor.getMessage(null, DISABLED_ENTITY, email);
            throw new DisabledEntityException(message);
        }
    }

    public void checkExisted(Long id) {
        final boolean isExisted = userRepository.existsById(id);

        if (!isExisted) {

            log.warn("User {} is not exist!", id);

            final String message = exceptionMessageAccessor.getMessage(null, NOT_EXISTS_USER, id);
            throw new DisabledEntityException(message);
        }
    }

}
