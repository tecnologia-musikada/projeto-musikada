package com.sistema.microservice.musikada.user.to.request;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

public class UpdateUserRequestTO {

    private String firstName;
    private String secondName;
    private String lastName;
    private CelPhoneTO celPhone;
    private String email;
    private List<AdressTO> adresses;
    private String documentType;
    private String documentNumber;


    @Schema(description = "Primeiro nome do usuário", required = true, example = "João")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Schema(description = "Segundo nome do usuário", required = true, example = "Armando")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Schema(description = "Sobre-nome do usuário", required = true, example = "José")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CelPhoneTO getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(CelPhoneTO celPhone) {
        this.celPhone = celPhone;
    }

    @Schema(description = "Representa um email válido do usuário", example = "exemplo@gmail.com")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AdressTO> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<AdressTO> adresses) {
        this.adresses = adresses;
    }

    @Schema(description = "Representa o tipo de documento usado", example = "BI")
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Schema(description = "Representa o numero de documento valido", example = "B9874C32145")
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
