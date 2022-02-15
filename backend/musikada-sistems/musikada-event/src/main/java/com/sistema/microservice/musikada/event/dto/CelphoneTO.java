package com.sistema.microservice.musikada.event.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CelphoneTO {

    @NotEmpty @NotNull
    private String phone1;
    private String phone2;
    private String phone3;

    @Schema(description = "Representa o telefone principal do organizador do evento", required = true, example = "+555199876532")
    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    @Schema(description = "Representa o telefone secundário do organizador do evento", example = "+555199876532")
    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    @Schema(description = "Representa o telefone secundário do organizador do evento", example = "+555199876532")
    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }
}