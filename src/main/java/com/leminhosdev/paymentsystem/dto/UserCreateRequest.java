package com.leminhosdev.paymentsystem.dto;


import com.leminhosdev.paymentsystem.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(
       @NotNull(message = "O nome não pode ser nulo")
       @NotBlank(message = "O nome não pode ser vazio")
       String name,
       @NotNull(message = "Email não pode ser nulo")
       @NotBlank(message = "Email não pode ser vazio")
       @Email
        String email,
       @NotNull(message = "Senha não pode ser nula")
       @NotBlank(message = "Senha não pode ser vazia")
       @Size(min = 8, message = "A senha deve conter no minimo 8 caracteres")
        String password) {

    public User toModel(){
       return new User(name,email,password);
    }
}
