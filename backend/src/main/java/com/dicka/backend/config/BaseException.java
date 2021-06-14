package com.dicka.backend.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class BaseException extends RuntimeException{

    protected HttpStatus httpStatus;
    protected String codeError;
    protected String errorMessage;
    protected String errorDescription;
    protected String rootCause;

    public BaseException(HttpStatus httpStatus, String codeError, String errorMessage, String errorDescription, String rootCause){
        super(rootCause);
        this.httpStatus = httpStatus;
        this.codeError = codeError;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public BaseException(HttpStatus httpStatus, String codeError, String rootCause){
        super(rootCause);
        this.httpStatus = httpStatus;
        this.codeError = codeError;
    }

}
