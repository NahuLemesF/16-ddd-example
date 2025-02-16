package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class FactionSurrendered extends DomainEvent {
    private final String id;
    private final Boolean isSurrendered;

    public FactionSurrendered(String id, Boolean isSurrendered) {
        super(EventsEnum.FACTION_SURRENDER.name());
        this.id = id;
        this.isSurrendered = isSurrendered;
    }

    public String getId() {
        return id;
    }
    
    public Boolean getIsSurrendered() {
        return isSurrendered;
    }
}
