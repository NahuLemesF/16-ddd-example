package com.twilightimperium.expansioncommand.application.createfaction;

import com.twilightimperium.shared.application.Request;

import java.util.List;

public class CreateFactionRequest extends Request {
    private final String name;
    private final String description;
    private final Boolean isSurrendered;
    private final String governmentType;
    private final Integer governmentLevel;
    private final List<String> technologiesList;

    public CreateFactionRequest(String name, String description, Boolean isSurrendered, String governmentType, Integer governmentLevel, List<String> technologiesList) {
        super(null);
        this.name = name;
        this.description = description;
        this.isSurrendered = isSurrendered;
        this.governmentType = governmentType;
        this.governmentLevel = governmentLevel;
        this.technologiesList = technologiesList;
    }

    public String getDescription() {
        return description;
    }

    public Integer getGovernmentLevel() {
        return governmentLevel;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public Boolean getSurrendered() {
        return isSurrendered;
    }

    public String getName() {
        return name;
    }

    public List<String> getTechnologiesList() {
        return technologiesList;
    }
}
