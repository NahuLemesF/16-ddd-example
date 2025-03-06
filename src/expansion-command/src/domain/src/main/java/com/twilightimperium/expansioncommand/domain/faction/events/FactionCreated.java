package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

import java.util.List;

public class FactionCreated extends DomainEvent {
    private String factionName;
    private String description;
    private Boolean isSurrendered;
    private String governmentType;
    private Integer governmentLevel;
    private List<String> technologiesList;

    public FactionCreated() {
        super(null);
    }

    public FactionCreated(String factionName, String description, Boolean isSurrendered, String governmentType, Integer governmentLevel, List<String> technologiesList) {
        super(EventsEnum.FACTION_CREATED.name());
        this.factionName = factionName;
        this.description = description;
        this.isSurrendered = isSurrendered;
        this.governmentType = governmentType;
        this.governmentLevel = governmentLevel;
        this.technologiesList = technologiesList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }

    public Integer getGovernmentLevel() {
        return governmentLevel;
    }

    public void setGovernmentLevel(Integer governmentLevel) {
        this.governmentLevel = governmentLevel;
    }

    public String getGovernmentType() {
        return governmentType;
    }

    public void setGovernmentType(String governmentType) {
        this.governmentType = governmentType;
    }

    public Boolean getSurrendered() {
        return isSurrendered;
    }

    public void setSurrendered(Boolean surrendered) {
        isSurrendered = surrendered;
    }

    public List<String> getTechnologiesList() {
        return technologiesList;
    }

    public void setTechnologiesList(List<String> technologiesList) {
        this.technologiesList = technologiesList;
    }
}
