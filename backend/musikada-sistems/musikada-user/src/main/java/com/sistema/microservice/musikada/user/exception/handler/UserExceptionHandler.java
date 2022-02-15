package com.sistema.microservice.musikada.user.exception.handler;

import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.to.response.ResponseTO;
import io.vertx.core.json.JsonObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserExceptionHandler implements ExceptionMapper<UserMusikadaException> {

    @Override
    public Response toResponse(UserMusikadaException exception) {
        ResponseTO responseTO = new ResponseTO();
        JsonObject json = new JsonObject();
        json.put("code", exception.getCode());
        json.put("message", exception.getMessage());
        responseTO.setJson(json.toString());
        return Response.status(Response.Status.OK).entity(json).build();
    }
}