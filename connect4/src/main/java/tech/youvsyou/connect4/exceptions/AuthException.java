package tech.youvsyou.connect4.exceptions;

import org.springframework.security.core.AuthenticationException;


public class AuthException extends AuthenticationException {
    String msg;
    public AuthException(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }
}
