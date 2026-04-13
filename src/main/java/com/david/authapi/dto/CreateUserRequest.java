package com.david.authapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {
    @NotBlank(message = "Usuário não pode ser vazio!")
    private String username;

    @NotBlank(message = "A senha não pode ser vazia!")
    @Size(min = 6, message = "A senha não pode ter menos de 6 caracteres!")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
