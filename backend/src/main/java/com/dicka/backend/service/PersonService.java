package com.dicka.backend.service;

import com.dicka.backend.config.ErrorCustomException;
import com.dicka.backend.entity.Person;
import com.dicka.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findPersonByEmail(String email){
        Optional<Person> findByEmailPerson = personRepository.findByEmail(email);
        if (!findByEmailPerson.isPresent()){
            throw new ErrorCustomException("001");
        }
        return findByEmailPerson.get();
    }

}
