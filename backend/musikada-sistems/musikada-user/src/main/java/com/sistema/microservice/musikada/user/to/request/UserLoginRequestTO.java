package com.sistema.microservice.musikada.user.to.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserLoginRequestTO {

    @Email @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String password;

    @Schema(description = "Representa um email válido de um usuário cadastrado no sistema", required = true ,example = "exemplo@gmail.com")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Schema(description = "É o password do usuário cadastrado no sistema ", required = true ,example = "Password@#12")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
