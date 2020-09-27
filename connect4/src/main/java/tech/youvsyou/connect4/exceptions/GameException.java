package tech.youvsyou.connect4.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.youvsyou.connect4.game.response.ErrorResponse;

@ControllerAdvice
public class GameException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleAuthException(CustomException customException){
        ErrorResponse error = new ErrorResponse(customException.getHttpStatus().value(), customException.getErrorDescription(), customException.getMessage());
        return new ResponseEntity<>(error, customException.getHttpStatus());
    }

}
