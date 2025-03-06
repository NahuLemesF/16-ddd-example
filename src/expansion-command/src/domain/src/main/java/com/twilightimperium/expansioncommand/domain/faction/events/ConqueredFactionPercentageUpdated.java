package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class ConqueredFactionPercentageUpdated extends DomainEvent {
    private String id;
    private Integer percentage;

    public ConqueredFactionPercentageUpdated(String name) {
        super(name);
    }

    public ConqueredFactionPercentageUpdated(String id, Integer percentage) {
        super(EventsEnum.CONQUERED_FACTION_PERCENTAGE_UPDATED.name());
        this.id = id;
        this.percentage = percentage;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
