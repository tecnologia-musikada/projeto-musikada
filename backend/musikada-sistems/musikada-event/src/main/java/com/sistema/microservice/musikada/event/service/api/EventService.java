package com.sistema.microservice.musikada.event.service.api;

import com.sistema.microservice.musikada.event.dto.request.NewEventRequestTO;
import com.sistema.microservice.musikada.event.dto.request.UpdateEventRequestTO;
import com.sistema.microservice.musikada.event.dto.response.EventResponseTO;

import java.util.List;

public interface EventService {
    public List<EventResponseTO> findAllEvents();
    public EventResponseTO findEventById(String eventId);
    public void newEvent(NewEventRequestTO dto);
    public void deleteEvent(String eventId);
    public void updateEvent(String eventId, UpdateEventRequestTO dto);
}
