package com.dicka.backend.errormessage;

import com.dicka.backend.errormessage.entity.ErrorMessage;
import com.dicka.backend.errormessage.repository.ErrorMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ErrorMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorMessageApplication.class, args);
	}

}

@Component
class CommandData implements CommandLineRunner{

	@Autowired
	private ErrorMessageRepository errorMessageRepository;

	@Override
	public void run(String... args) throws Exception {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setCodeError("001");
		errorMessage.setErrorMessage("Data tidak ditemukan");
		errorMessage.setErrorDescription("Data di database tidak ada");
		errorMessageRepository.save(errorMessage);
	}
}
