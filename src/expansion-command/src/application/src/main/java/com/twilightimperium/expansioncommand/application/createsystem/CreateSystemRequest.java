package com.twilightimperium.expansioncommand.application.createsystem;

import com.twilightimperium.shared.application.Request;

import java.util.List;

public class CreateSystemRequest extends Request {
    private final Integer number;
    private final String factionId;
    private final List<String> planetsList;

    protected CreateSystemRequest(Integer number, String factionId, List<String> planetsList) {
        super(null);
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

    // endregion
}
