package com.sistema.microservice.musikada.user.to.response;

import com.sistema.microservice.musikada.user.to.request.AdressTO;
import com.sistema.microservice.musikada.user.to.request.CelPhoneTO;
import org.bson.types.ObjectId;

import java.util.List;

public class UserResponseTO {

    private String userId;
    private String firstName;
    private String secondName;
    private String lastName;
    private CelPhoneTO celPhone;
    private String email;
    private List<AdressTO> adresses;
    private String documentType;
    private String documentNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}