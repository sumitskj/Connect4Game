package tech.youvsyou.connect4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import tech.youvsyou.connect4.game.request.RegisterRequest;
import tech.youvsyou.connect4.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/v1/connect4")
public class AccessController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
        if(userService.register(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmailId())){
            return new ResponseEntity<>("User Created", HttpStatus.CREATED);
        }
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return new ResponseEntity<>("EmailId is already registered.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/logout")
    public void logoutUser(){
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
    }

}
