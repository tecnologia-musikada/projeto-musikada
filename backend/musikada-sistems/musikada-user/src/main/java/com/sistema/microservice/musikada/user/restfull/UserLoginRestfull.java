package com.sistema.microservice.musikada.user.restfull;

import com.sistema.microservice.musikada.user.controller.api.UserControllerService;
import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.to.request.UserLoginCredentialsUpdatingRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginRequestTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Tag(name = "Módulo responsável em lidar com login dos usuários")
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserLoginRestfull {

    @Inject
    UserControllerService userControllerService;

    @POST
    @Path("login")
    @Operation(summary = "Permite ao usuário musikada realizar login")
    @APIResponse(responseCode = "200", description = "Retorna um valor boolean", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response makeLogin(UserLoginRequestTO dto) throws UserMusikadaException {
        boolean status = userControllerService.makeLogin(dto);
        return Response.ok().entity(status).build();
    }

    @POST
    @Path("forgetPassword/{email}")
    @Operation(summary = "Permite ao usuário solicitar a função esquecer senha ao sistema")
    @APIResponse(responseCode = "200", description = "Retorna um valor boolean", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Parameter(in = ParameterIn.PATH, name = "email", example = "exemplo@gmail.com", description = "Um email válido do usuário existente no sistema", required = true)
    public Response forgetPassword(@PathParam("email") String email) throws UserMusikadaException{
        boolean status = userControllerService.forgetPassword(email);
        return Response.ok().entity(status).build();
    }

    @PUT
    @Path("update-login-credentials")
    public Response updateLoginCredentials(UserLoginCredentialsUpdatingRequestTO dto) throws UserMusikadaException{
        boolean status = userControllerService.userUpdateLoginCredentials(dto);
        return Response.ok().entity(status).build();
    }
}