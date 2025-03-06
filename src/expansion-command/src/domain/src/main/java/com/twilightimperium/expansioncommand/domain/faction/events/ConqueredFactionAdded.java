package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

import java.time.Instant;

public class ConqueredFactionAdded extends DomainEvent {
    private String factionName;
    private Integer percentage;

    public ConqueredFactionAdded() {
        super(null);
    }

    public ConqueredFactionAdded(String factionName, Integer percentage) {
        super(EventsEnum.CONQUERED_FACTION_ADDED.name());
        this.factionName = factionName;
        this.percentage = percentage;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public String getFactionName() {
        return factionName;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public void setFactionName(String factionName) {
        this.factionName = factionName;
    }
}
