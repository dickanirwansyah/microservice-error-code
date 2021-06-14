package com.dicka.backend.errormessage.controller;

import com.dicka.backend.errormessage.entity.ErrorMessage;
import com.dicka.backend.errormessage.repository.ErrorMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/error/message")
public class ErrorController {

    @Autowired
    private ErrorMessageRepository errorMessageRepository;

    @PostMapping(value = "/error-message-by-code/{code}")
    public ResponseEntity<ErrorMessage> errorMessageByCode(@PathVariable("code")String code){
        Optional<ErrorMessage> findErrorByCode = errorMessageRepository.findById(code);
        if (!findErrorByCode.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(findErrorByCode.get(), HttpStatus.OK);
    }
}
