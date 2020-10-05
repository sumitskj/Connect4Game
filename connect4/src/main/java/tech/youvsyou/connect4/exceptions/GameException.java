package tech.youvsyou.connect4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.youvsyou.connect4.game.response.ErrorResponse;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class GameException extends ResponseEntityExceptionHandler {
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ErrorResponse> handleLoginException(AuthenticationException customException){
        ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), customException.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleAuthException(CustomException customException){
        ErrorResponse error = new ErrorResponse(customException.getHttpStatus().value(), customException.getErrorDescription(), customException.getMessage());
        return new ResponseEntity<>(error, customException.getHttpStatus());
    }

}
