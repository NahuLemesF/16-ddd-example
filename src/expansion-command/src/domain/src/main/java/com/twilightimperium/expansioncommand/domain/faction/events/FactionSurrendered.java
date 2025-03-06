package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class FactionSurrendered extends DomainEvent {
    private Boolean isSurrendered;

    public FactionSurrendered(String name) {
        super(name);
    }

    public FactionSurrendered(Boolean isSurrendered) {
        super(EventsEnum.FACTION_SURRENDER.name());
        this.isSurrendered = isSurrendered;
    }
    
    public Boolean getIsSurrendered() {
        return isSurrendered;
    }

    public void setIsSurrendered(Boolean isSurrendered) {
        this.isSurrendered = isSurrendered;
    }
}
