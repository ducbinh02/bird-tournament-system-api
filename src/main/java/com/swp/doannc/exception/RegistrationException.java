
package com.swp.doannc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * RegistrationException
 */
@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {
    final String errorMessage;

}
