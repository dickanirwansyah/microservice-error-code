package com.dicka.backend.config;

import com.dicka.backend.model.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Configuration
public class ErrorConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ErrorConfiguration.class);
    private static final String DEFAULT_CODE_ERROR = "8000";
    private static final String API_ERROR = "http://localhost:9999/error/message/error-message-by-code/";

    @Autowired
    private RestTemplate restTemplate;

    public ErrorResponse errorResponse(String code){

        ErrorResponse errorResponse = new ErrorResponse();
        try{
            log.debug("CALLING TO API ERROR MESSAGE WITH CODE "+code);
            errorResponse = restTemplate.postForObject(API_ERROR+code, "", ErrorResponse.class);
            log.info("RESPONSE ERRROR : "+errorResponse);
            return errorResponse;
        }catch (Exception e){
            log.error("FAILED TO GET MESSAGE WITH CODE "+code);
            errorResponse.setCodeError(DEFAULT_CODE_ERROR);
            errorResponse.setErrorDescription("System error.");
            errorResponse.setErrorMessage("permintaan anda tidak dapat dilakukan.");
            log.info("RESPONSE ERROR : "+errorResponse);
            return errorResponse;
        }
    }
}
