package com.dicka.backend.controller;

import com.dicka.backend.entity.Person;
import com.dicka.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "get-person-by-email/{email}")
    public Person getPersonByEmail(@PathVariable("email")String email){
        Person getPersonByEmail = personService.findPersonByEmail(email);
        return getPersonByEmail;
    }
}
