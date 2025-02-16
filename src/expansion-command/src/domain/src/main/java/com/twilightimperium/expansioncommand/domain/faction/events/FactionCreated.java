package com.twilightimperium.expansioncommand.domain.faction.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class FactionCreated extends DomainEvent {
    private final String name;
    private final String description;

    public FactionCreated(String name, String description) {
        super(EventsEnum.FACTION_CREATED.name());
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
