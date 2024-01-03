package com.leminhosdev.paymentsystem.dto;


import com.leminhosdev.paymentsystem.entity.User;

public record UserRequest(String name, String email, String password) {

    public User toModel(){
       return new User(name,email,password);
    }
}
