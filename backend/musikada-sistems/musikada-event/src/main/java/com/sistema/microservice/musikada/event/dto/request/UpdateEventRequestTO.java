package com.sistema.microservice.musikada.event.dto.request;

import com.sistema.microservice.musikada.event.dto.AdressTO;
import com.sistema.microservice.musikada.event.dto.CelphoneTO;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateEventRequestTO {
    @NotEmpty
    @NotNull
    private String eventTitle;
    @NotEmpty @NotNull
    private String eventDescription;
    @NotEmpty @NotNull
    private String eventOrganizers;
    @NotEmpty @NotNull
    private String eventPrice;
    @NotEmpty @NotNull
    private String eventStartDate;
    @NotEmpty @NotNull
    private String eventFinishDate;
    private CelphoneTO eventContact;
    private AdressTO eventAdress;
    @NotEmpty @NotNull
    private String eventOwner;

    @Schema(description = "Representa o título do evento", required = true, example = "os compadres")
    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    @Schema(description = "Representa a descrição do evento", required = true, example = "Festa alusivo aos amigos do musikada")
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Schema(description = "Representa um email válido do organizador do evento", required = true, example = "exemplo@gmail.com")
    public String getEventOrganizers() {
        return eventOrganizers;
    }

    public void setEventOrganizers(String eventOrganizers) {
        this.eventOrganizers = eventOrganizers;
    }

    @Schema(description = "Preço do evento", required = true, example = "2000")
    public String getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(String eventPrice) {
        this.eventPrice = eventPrice;
    }


    @Schema(description = "Data de início do evento", required = true, example = "01/03/2022 00:00:00")
    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    @Schema(description = "Data de término do evento", required = true, example = "02/03/2022 00:00:00")
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

    @Schema(description = "É o proprietário do evento", example = "Kangamba" , required = true)
    public String getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(String eventOwner) {
        this.eventOwner = eventOwner;
    }

}
