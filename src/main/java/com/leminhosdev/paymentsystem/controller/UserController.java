package com.leminhosdev.paymentsystem.controller;

import com.leminhosdev.paymentsystem.dto.AuthenticationRequest;
import com.leminhosdev.paymentsystem.dto.AuthenticationResponse;
import com.leminhosdev.paymentsystem.dto.UserCreateRequest;
import com.leminhosdev.paymentsystem.dto.UserResponse;
import com.leminhosdev.paymentsystem.entity.User;
import com.leminhosdev.paymentsystem.service.TokenService;
import com.leminhosdev.paymentsystem.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid UserCreateRequest userCreateRequest) throws MessagingException, UnsupportedEncodingException {
        User user = userCreateRequest.toModel();
        UserResponse userSaved = userService.registerUser(user);
        return ResponseEntity.ok().body(userSaved);
    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code){
        if(userService.verify(code)){
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
    @GetMapping("/teste")
    public String teste(){
        return "você está logado";
    }

}
