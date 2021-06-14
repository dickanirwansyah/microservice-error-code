package com.dicka.backend.config;

import com.dicka.backend.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Configuration
public class ErrorHelper {

    private static final Logger log = LoggerFactory.getLogger(ErrorHelper.class);

    @Autowired
    private ErrorConfiguration errorConfiguration;

    public ResponseEntity<ErrorResponse> throwError(String code, HttpStatus httpStatus){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCodeError(code);

        ErrorResponse responseError = errorConfiguration.errorResponse(code);
        errorResponse.setCodeError(responseError.getCodeError());
        errorResponse.setErrorDescription(responseError.getErrorDescription());
        errorResponse.setErrorMessage(responseError.getErrorMessage());

        return new ResponseEntity<>(errorResponse, new HttpHeaders(), httpStatus);
    }

}
