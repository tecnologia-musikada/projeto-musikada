package com.sistema.microservice.musikada.user.to.response;

public class ResponseTO {

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String json;
    private boolean status;
}
