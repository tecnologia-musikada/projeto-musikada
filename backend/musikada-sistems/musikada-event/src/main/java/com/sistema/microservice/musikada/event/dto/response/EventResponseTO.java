package com.sistema.microservice.musikada.event.dto.response;

import com.sistema.microservice.musikada.event.dto.AdressTO;
import com.sistema.microservice.musikada.event.dto.CelphoneTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class EventResponseTO {

    private String eventId;
    private String eventTitle;
    private String eventDescription;
    private String eventOrganizers;
    private String eventPrice;
    private String eventStartDate;
    private String eventFinishDate;
    private CelphoneTO eventContact;
    private AdressTO eventAdress;
    private String eventOwner;


    @Schema(description = "Representa o título do evento", required = true, example = "noite da farra")
    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    @Schema(description = "Representa a descrição do evento", required = true, example = "Festa alusivo aos que gostam de farra")
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Schema(description = "Representa o organizador do evento", required = true, example = "os compadres")
    public String getEventOrganizers() {
        return eventOrganizers;
    }

    public void setEventOrganizers(String eventOrganizers) {
        this.eventOrganizers = eventOrganizers;
    }

    @Schema(description = "Preço do evento", example = "2000")
    public String getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }


    @Schema(description = "Data de início do evento", example = "01/03/2022 00:00:00")
    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    @Schema(description = "Data de término do evento", example = "02/03/2022 00:00:00")
    public String getEventFinishDate() {
        return eventFinishDate;
    }

    public void setEventFinishDate(String eventFinishDate) {
        this.eventFinishDate = eventFinishDate;
    }

    @Schema(description = "São os contactos dos organizadores do evento")
    public CelphoneTO getEventContact() {
        return eventContact;
    }

    public void setEventContact(CelphoneTO eventContact) {
        this.eventContact = eventContact;
    }

    @Schema(description = "Define o enedereço aonde vai ocorrer o evento")
    public AdressTO getEventAdress() {
        return eventAdress;
    }

    public void setEventAdress(AdressTO eventAdress) {
        this.eventAdress = eventAdress;
    }

    @Schema(description = "É o proprietário do evento", example = "Kangamba")
    public String getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(String eventOwner) {
        this.eventOwner = eventOwner;
    }

    @Schema(description = "É o identificador de um  evento", example = "61dcaaec50363056a9ca9811")
    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}