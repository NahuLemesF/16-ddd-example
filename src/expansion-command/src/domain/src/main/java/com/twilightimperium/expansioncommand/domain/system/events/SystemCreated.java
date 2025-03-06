package com.twilightimperium.expansioncommand.domain.system.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

import java.util.List;

public class SystemCreated extends DomainEvent {
    private Integer number;
    private String factionId;
    private List<String> planetsList;

    public SystemCreated() {
        super(null);
    }

    public SystemCreated(Integer number, String factionId, List<String> planetsList) {
        super(EventsEnum.SYSTEM_CREATED.name());
        this.number = number;
        this.factionId = factionId;
        this.planetsList = planetsList;
    }

    public Integer getNumber() {
        return number;
    }

    public String getFactionId() {
        return factionId;
    }

    public List<String> getPlanetsList() {
        return planetsList;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    public void setPlanetsList(List<String> planetsList) {
        this.planetsList = planetsList;
    }
}
