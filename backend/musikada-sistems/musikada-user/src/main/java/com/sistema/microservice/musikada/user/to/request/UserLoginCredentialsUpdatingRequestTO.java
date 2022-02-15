package com.sistema.microservice.musikada.user.to.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserLoginCredentialsUpdatingRequestTO {
    @Email @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String newPassword;

    @NotNull @NotEmpty
    private String confirmPassword;

    @Schema(description = "Representa um email válido de um usuário cadastrado no sistema", required = true ,example = "exemplo@gmail.com")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Schema(description = "É o novo password do usuário cadastrado no sistema ", required = true ,example = "Password@#12")
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Schema(description = "É a confirmação do novo password do usuário cadastrado no sistema ", required = true ,example = "Password@#12")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
