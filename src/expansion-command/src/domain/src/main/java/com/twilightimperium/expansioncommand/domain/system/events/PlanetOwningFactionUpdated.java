package com.twilightimperium.expansioncommand.domain.system.events;

import com.twilightimperium.shared.domain.generic.DomainEvent;

public class PlanetOwningFactionUpdated extends DomainEvent {
    private String id;
    private String owningFaction;

    public PlanetOwningFactionUpdated(String name) {
        super(name);
    }

    public PlanetOwningFactionUpdated(String id, String owningFaction) {
        super(EventsEnum.PLANET_OWNING_FACTION_UPDATED.name());
        this.id = id;
        this.owningFaction = owningFaction;
    }

    public String getId() {
        return id;
    }

    public String getOwningFaction() {
        return owningFaction;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOwningFaction(String owningFaction) {
        this.owningFaction = owningFaction;
    }
}
