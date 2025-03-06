package com.twilightimperium.expansioncommand.application.createsystem;

import com.twilightimperium.shared.application.Request;

import java.util.List;

public class CreateSystemRequest extends Request {
    private Integer number;
    private String factionId;
    private List<String> planetsList;


    protected CreateSystemRequest(String aggregateId, Integer number, String factionId, List<String> planetsList) {
        super(aggregateId);
        this.number = number;
        this.factionId = factionId;
        this.planetsList = planetsList;
    }

    // region Getters

    public String getFactionId() {
        return factionId;
    }

    public Integer getNumber() {
        return number;
    }

    public List<String> getPlanetsList() {
        return planetsList;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setPlanetsList(List<String> planetsList) {
        this.planetsList = planetsList;
    }

    // endregion
}
