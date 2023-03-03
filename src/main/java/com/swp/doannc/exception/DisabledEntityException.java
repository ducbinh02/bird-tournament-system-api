package com.swp.doannc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DisabledEntityException extends RuntimeException {

    private final String errorMessage;

}
