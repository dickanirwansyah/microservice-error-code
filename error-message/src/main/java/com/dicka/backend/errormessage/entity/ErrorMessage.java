package com.dicka.backend.errormessage.entity;

import javax.persistence.*;

@Entity
@Table(name = "error_message")
public class ErrorMessage {

    @Id
    @Column(name = "code_error")
    private String codeError;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "error_description")
    private String errorDescription;

    public ErrorMessage(){}

    public ErrorMessage(String codeError, String errorMessage, String errorDescription){
        this.codeError = codeError;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "codeError='" + codeError + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
