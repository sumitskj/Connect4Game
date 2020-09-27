package tech.youvsyou.connect4.exceptions;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception{
    private String errorDescription;
    private HttpStatus httpStatus;
    private String message;

    public CustomException() {
    }

    public CustomException(String errorDescription, HttpStatus httpStatus, String message) {
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
