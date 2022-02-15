package com.sistema.microservice.musikada.user.restfull;

import com.sistema.microservice.musikada.user.controller.api.UserControllerService;
import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.to.request.NewUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UpdateUserRequestTO;
import com.sistema.microservice.musikada.user.to.response.UserResponseTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Módulo responsável em manipular os usuários do Musikada no DB", description = "Este módulo contempla o conjunto de endpoints exclusivos para manipulação os usuários musikada"
        +"(Os seus EndPoints se comunicam com o Banco de dados)")
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRestfull {

    @Inject
    UserControllerService services;

    @GET
    @Operation(summary = "Buscar todos os usuários no sistema musikada")
    @APIResponse(responseCode = "200", description = "Retorna uma lista de usuários", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserResponseTO.class, type = SchemaType.ARRAY)))
    public Response findAllUsers(){
        List<UserResponseTO> responseTO = services.findAllUsers();
        return Response.ok(200).entity(responseTO).build();
    }

    @POST
    @Operation(summary = "Cria um novo usuário no sistema musikada")
    @Parameter(schema = @Schema(implementation = NewUserRequestTO.class))
    public Response newUser(@Valid NewUserRequestTO dto) throws UserMusikadaException{
       services.createnewUser(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{userId}")
    @Operation(summary = "Exclui um usuário no sistema musikada")
    @Parameter(in = ParameterIn.PATH, name = "userId", example = "f25ba892-95e0-11ea-bb37-0242ac130002", description = "Identificador de um usuário no sistema", required = true)
    public  Response deleteUser(@PathParam("userId") String userId) throws UserMusikadaException {
        services.deleteUser(userId);
        return Response.ok(200).build();
    }

    @PUT
    @Path("{userId}")
    @Operation(summary = "Atualiza as informações de um novo usuário no sistema musikada")
    @Parameter(schema = @Schema(implementation = NewUserRequestTO.class))
    public Response updateUser(@PathParam("userId") String userId, UpdateUserRequestTO dto) throws UserMusikadaException{
        services.updateUser(userId, dto);
        return Response.ok(200).build();
    }

    @GET
    @Path("{userId}")
    @Operation(summary = "Busca um único usuário no sistema musikada")
    @APIResponse(responseCode = "200", description = "Retorna um usuários", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserResponseTO.class, type = SchemaType.OBJECT)))
    public Response findUserById(@PathParam("userId") String userId) throws UserMusikadaException{
        UserResponseTO userResponseTO = services.findUserById(userId);
        return Response.ok(20).entity(userResponseTO).build();
    }
}
