package com.sistema.microservice.musikada.event.service.impl;

import com.sistema.microservice.musikada.event.dto.request.NewEventRequestTO;
import com.sistema.microservice.musikada.event.dto.request.UpdateEventRequestTO;
import com.sistema.microservice.musikada.event.dto.response.EventResponseTO;
import com.sistema.microservice.musikada.event.entities.Event;
import com.sistema.microservice.musikada.event.mapper.EventMapperObject;
import com.sistema.microservice.musikada.event.service.api.EventService;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EventServiceImpl implements EventService {
    @Inject
    private EventMapperObject eventMapperObject;

    @Override
    public List<EventResponseTO> findAllEvents() {
        List<Event> events = Event.listAll();
        List<EventResponseTO> eventsResponseTo = new ArrayList<>();

        for (Event event: events) {
            EventResponseTO eventResponseTO = eventMapperObject.convertEventToEventResponse(event);
            eventResponseTO.setEventId(event.id.toString());
            eventsResponseTo.add(eventResponseTO);
        }
        return eventsResponseTo;
    }

    @Override
    public EventResponseTO findEventById(String eventId) {
        ObjectId objectId = new ObjectId(eventId);
        Optional<Event> eventOptional = Event.findByIdOptional(objectId);
        EventResponseTO eventResponseTO = null;
        if (!eventOptional.isEmpty())
            eventResponseTO = eventMapperObject.convertEventToEventResponse(eventOptional.get());
        else
            throw new NotFoundException("Event not found");
        return eventResponseTO;
    }

    @Override
    public void newEvent(NewEventRequestTO dto) {
        Event event = eventMapperObject.convertNewEventrequestToEvent(dto);
        event.persist();
    }

    @Override
    public void deleteEvent(String eventId) {
        ObjectId objectId = new ObjectId(eventId);
        Optional<Event> userOptional = Event.findByIdOptional(objectId);
        userOptional.ifPresentOrElse(Event::delete, ()-> {throw new NotFoundException("User not found");});
    }

    @Override
    public void updateEvent(String eventId, UpdateEventRequestTO dto) {
        ObjectId objectId = new ObjectId(eventId);
        Event event = eventMapperObject.convertUpdateEventToEvent(dto);
        event.id = objectId;
        event.update();
    }
}