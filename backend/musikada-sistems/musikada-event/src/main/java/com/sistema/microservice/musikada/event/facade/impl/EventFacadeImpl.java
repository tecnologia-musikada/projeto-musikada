package com.sistema.microservice.musikada.event.facade.impl;

import com.sistema.microservice.musikada.event.dto.request.NewEventRequestTO;
import com.sistema.microservice.musikada.event.dto.request.UpdateEventRequestTO;
import com.sistema.microservice.musikada.event.dto.response.EventResponseTO;
import com.sistema.microservice.musikada.event.facade.api.EventFacade;
import com.sistema.microservice.musikada.event.service.api.EventService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class EventFacadeImpl implements EventFacade {
    @Inject
    private EventService eventService;

    @Override
    public List<EventResponseTO> findAllEvents() {
        return eventService.findAllEvents();
    }

    @Override
    public EventResponseTO findEventById(String eventId) {
        return eventService.findEventById(eventId);
    }

    @Override
    public void newEvent(NewEventRequestTO dto) {
        eventService.newEvent(dto);
    }

    @Override
    public void deleteEvent(String eventId) {
        eventService.findEventById(eventId);
    }

    @Override
    public void updateEvent(String eventId, UpdateEventRequestTO dto) {
        eventService.updateEvent(eventId, dto);
    }
}