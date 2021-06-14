package com.dicka.backend.config;

import com.dicka.backend.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorException {

    @Autowired
    private ErrorHelper errorHelper;

    private static final Logger log = LoggerFactory.getLogger(GlobalErrorException.class);

    @ExceptionHandler(ErrorCustomException.class)
    protected ResponseEntity<ErrorResponse> errorBussiness(ErrorCustomException ex){
        log.error("error custom bussiness : ",ex);

        return errorHelper.throwError(ex.getCodeError(), ex.httpStatus);
    }
}
