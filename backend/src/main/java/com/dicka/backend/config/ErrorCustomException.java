package com.dicka.backend.config;

import org.springframework.http.HttpStatus;

public class ErrorCustomException extends BaseException {

    public ErrorCustomException(HttpStatus httpStatus, String codeError, String errorMessage, String errorDescription, String rootCause) {
        super(HttpStatus.NOT_ACCEPTABLE, codeError, errorMessage, errorDescription, rootCause);
    }

    public ErrorCustomException(String codeError) {
        super(HttpStatus.NOT_ACCEPTABLE, codeError, "");
    }

}
