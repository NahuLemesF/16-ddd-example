package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.expansioncommand.domain.faction.entities.Technology;
import com.twilightimperium.shared.domain.generic.DomainEvent;

import java.util.List;

public class FactionCreated extends DomainEvent {
    private final String name;
    private final String description;
    private final Boolean isSurrendered;
    private final String governmentType;
    private final Integer governmentLevel;
    private final List<String> technologiesList;

    public FactionCreated(String name, String description, Boolean isSurrendered, String governmentType, Integer governmentLevel, List<String> technologiesList) {
        super(EventsEnum.FACTION_CREATED.name());
        this.name = name;
        this.description = description;
        this.isSurrendered = isSurrendered;
        this.governmentType = governmentType;
        this.governmentLevel = governmentLevel;
        this.technologiesList = technologiesList;
    }


    @Override
    public String getName() {
        return name;
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

    public List<String> getTechnologiesList() {
        return technologiesList;
    }
}
