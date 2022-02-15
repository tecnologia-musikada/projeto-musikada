package com.sistema.microservice.musikada.event.mapper;

import com.sistema.microservice.musikada.event.dto.request.NewEventRequestTO;
import com.sistema.microservice.musikada.event.dto.request.UpdateEventRequestTO;
import com.sistema.microservice.musikada.event.dto.response.EventResponseTO;
import com.sistema.microservice.musikada.event.entities.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface EventMapperObject {
    public Event convertNewEventrequestToEvent(NewEventRequestTO dto);
    public Event convertUpdateEventToEvent(UpdateEventRequestTO dto);
    public EventResponseTO convertEventToEventResponse(Event entity);
}
