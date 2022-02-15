package com.sistema.microservice.musikada.event.restfull;

import com.sistema.microservice.musikada.event.dto.request.NewEventRequestTO;
import com.sistema.microservice.musikada.event.dto.request.UpdateEventRequestTO;
import com.sistema.microservice.musikada.event.dto.response.EventResponseTO;
import com.sistema.microservice.musikada.event.facade.api.EventFacade;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(name = "Módulo responsável em lidar com os eventos do musikada")
@Path("events")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventsRestfull {

    @Inject
    EventFacade facade;

    @GET
    @Operation(summary = "Busca todos os eventos no sistema")
    @APIResponse(responseCode = "200", description = "Retorna uma lista de eventos", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = EventResponseTO.class, type = SchemaType.ARRAY)))
    public Response getAllEvents(){
        List<EventResponseTO> events = facade.findAllEvents();
        return Response.ok().entity(events).build();
    }

    @GET
    @Path("{eventId}")
    @Operation(summary = "Busca um único evento no sistema musikada")
    @APIResponse(responseCode = "200", description = "Retorna um evento", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = EventResponseTO.class, type = SchemaType.OBJECT)))
    @Parameter(in = ParameterIn.PATH, name = "eventId", example = "61dcaaec50363056a9ca9811", description = "Identificador de um evento no sistema", required = true)
    public Response findEventById(@PathParam("eventId") String eventId){
        EventResponseTO event = facade.findEventById(eventId);
        return Response.ok().entity(event).build();
    }

    @POST
    @Operation(summary = "Cria um novo evento no sistema musikada")
    @Parameter(schema = @Schema(implementation = NewEventRequestTO.class))
    public Response createNewEvent(NewEventRequestTO dto){
        facade.newEvent(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{eventId}")
    @Operation(summary = "Exclui um event no sistema musikada")
    @Parameter(in = ParameterIn.PATH, name = "eventId", example = "61dcaaec50363056a9ca9811", description = "Identificador de um evento no sistema", required = true)
    public Response deleteEvent(@PathParam("eventId") String eventId){
        facade.deleteEvent(eventId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{eventId}")
    @Operation(summary = "Atualiza um event no sistema musikada")
    @Parameter(in = ParameterIn.PATH, name = "eventId", example = "61dcaaec50363056a9ca9811", description = "Identificador de um evento no sistema", required = true)
    public Response updateEvent(@PathParam("eventId") String eventId, UpdateEventRequestTO dto){
        facade.updateEvent(eventId, dto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
