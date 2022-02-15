package com.sistema.microservice.musikada.event.facade.api;

import com.sistema.microservice.musikada.event.dto.request.NewEventRequestTO;
import com.sistema.microservice.musikada.event.dto.request.UpdateEventRequestTO;
import com.sistema.microservice.musikada.event.dto.response.EventResponseTO;

import java.util.List;

public interface EventFacade {
    public List<EventResponseTO> findAllEvents();
    public EventResponseTO findEventById(String eventId);
    public void newEvent(NewEventRequestTO dto);
    public void deleteEvent(String eventId);
    public void updateEvent(String eventId, UpdateEventRequestTO dto);
}
