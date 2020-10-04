package tech.youvsyou.connect4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.youvsyou.connect4.game.response.ErrorResponse;

@ControllerAdvice
public class GameException {
    @ExceptionHandler({AuthException.class})
    public ResponseEntity<ErrorResponse> handleLoginException(AuthException customException){
        ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), customException.getMsg());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleAuthException(CustomException customException){
        ErrorResponse error = new ErrorResponse(customException.getHttpStatus().value(), customException.getErrorDescription(), customException.getMessage());
        return new ResponseEntity<>(error, customException.getHttpStatus());
    }

}
