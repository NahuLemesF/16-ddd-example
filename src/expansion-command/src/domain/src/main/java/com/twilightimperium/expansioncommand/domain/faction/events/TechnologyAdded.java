package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class TechnologyAdded extends DomainEvent {
    private String techName;
    private Integer level;

    public TechnologyAdded() {
        super(null);
    }

    public TechnologyAdded(String techName, Integer level) {
        super(EventsEnum.TECHNOLOGY_ADDED.name());
        this.techName = techName;
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public String getFactionName() {
        return techName;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }
}
