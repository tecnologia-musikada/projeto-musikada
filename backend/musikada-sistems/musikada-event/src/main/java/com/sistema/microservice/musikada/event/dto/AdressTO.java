package com.sistema.microservice.musikada.event.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AdressTO {

    @NotEmpty @NotNull
    private String street;
    private String number;
    private String zipCode;
    @NotEmpty @NotNull
    private String reference1;
    private String reference2;
    @NotEmpty @NotNull
    private String city;
    @NotEmpty @NotNull
    private String provincyOrState;
    @NotEmpty @NotNull
    private String country;

    @Schema(description = "Rua do usuário", required = true, example = "Castanheira")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Schema(description = "Número da casa", example = "1055")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Schema(description = "Caixa postal", example = "93010004")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Schema(description = "Representa algum local próximo da rua ou casa que é de fácil localização", required = true,example = "Banco BIC")
    public String getReference1() {
        return reference1;
    }

    public void setReference1(String reference1) {
        this.reference1 = reference1;
    }

    @Schema(description = "Representa o segundo local próximo da rua ou casa que é de fácil localização", example = "Próximo a esquadra policial")
    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    @Schema(description = "Representa uma cidade ou município válido", required = true, example = "Namibe")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Schema(description = "Representa uma província ou estado válido", required = true, example = "Namibe")
    public String getProvincyOrState() {
        return provincyOrState;
    }

    public void setProvincyOrState(String provincyOrState) {
        this.provincyOrState = provincyOrState;
    }

    @Schema(description = "Representa país", required = true, example = "Angola")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
