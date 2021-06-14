package com.dicka.backend.errormessage.repository;

import com.dicka.backend.errormessage.entity.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, String> {

}
