package com.sistema.microservice.musikada.event.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "events", database = "musikada")
public class Event extends PanacheMongoEntity {
    private String eventTitle;
    private String eventDescription;
    private String eventOrganizers;
    private String eventPrice;
    private String eventStartDate;
    private String eventFinishDate;
    private Celphone eventContact;
    private Adress eventAdress;
    private String eventOwner;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventOrganizers() {
        return eventOrganizers;
    }

    public void setEventOrganizers(String eventOrganizers) {
        this.eventOrganizers = eventOrganizers;
    }

    public String getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventFinishDate() {
        return eventFinishDate;
    }

    public void setEventFinishDate(String eventFinishDate) {
        this.eventFinishDate = eventFinishDate;
    }

    public Celphone getEventContact() {
        return eventContact;
    }

    public void setEventContact(Celphone eventContact) {
        this.eventContact = eventContact;
    }

    public Adress getEventAdress() {
        return eventAdress;
    }

    public void setEventAdress(Adress eventAdress) {
        this.eventAdress = eventAdress;
    }

    public String getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(String eventOwner) {
        this.eventOwner = eventOwner;
    }
}