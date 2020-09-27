package tech.youvsyou.connect4.service;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class TokenGeneratorService {
    public String getToken(){
        return UUID.randomUUID().toString();
    }
}
